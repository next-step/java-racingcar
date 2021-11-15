package edu.nextstep.camp.racinggame.domain.race;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.nextstep.camp.racinggame.domain.car.Car;
import edu.nextstep.camp.racinggame.domain.car.Cars;
import edu.nextstep.camp.racinggame.domain.car.Name;
import edu.nextstep.camp.racinggame.domain.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.racinggame.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.racinggame.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class RaceTest {
    static Cars testCars() {
        return Cars.of(Stream.of("test0", "test1", "test2", "test3")
                        .map(Name::of)
                        .collect(Collectors.toList()),
                ALWAYS_MOVE_POLICY);
    }

    static Cars testCarAsList() {
        return Cars.of(Car.of(Name.of("test0"), ALWAYS_MOVE_POLICY));
    }


    static Stream<Arguments> parseValidRaceArguments() {
        return Stream.of(
                Arguments.of(testCarAsList(), Turns.of(1)),
                Arguments.of(testCarAsList(), Turns.of(1000)),
                Arguments.of(testCars(), Turns.of(1)),
                Arguments.of(testCars(), Turns.of(1000))
        );
    }

    @ParameterizedTest(name = "create race test: {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void create(Cars cars, Turns turns) {
        final Race race = Race.of(cars, turns);
        assertThat(race.numberOfCars()).isEqualTo(cars.size());
        assertThat(race.totalTurns()).isEqualTo(turns.total());
    }

    static Stream<Arguments> parseIllegalArgumentsOfRace() {
        return Stream.of(
                Arguments.of(null, Turns.of(1)),
                Arguments.of(testCars(), null)
        );
    }

    @ParameterizedTest(name = "failed to create race: {arguments}")
    @MethodSource("parseIllegalArgumentsOfRace")
    public void createFailed(Cars cars, Turns turns) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(cars, turns));
    }

    static Collection<Position> expectedPositions(int size, int position) {
        final Position[] expected = new Position[size];
        Arrays.fill(expected, Position.of(position));
        return Arrays.asList(expected);
    }

    @ParameterizedTest(name = "get game result(initial status): {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void gameResult(Cars cars, Turns turns) {
        final Race race = Race.of(cars, turns);
        assertThat(race.gameResult()).hasSameElementsAs(expectedPositions(cars.size(), 0));
    }

    @ParameterizedTest(name = "process game during given turns: {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void process(Cars cars, Turns turns) {
        final Race race = Race.of(cars, turns);
        final Collection<Position> expected = expectedPositions(cars.size(), turns.total().toInt());
        assertThat(race.isEnded()).isFalse();

        while (!race.isEnded()) {
            race.process();
        }

        assertThat(race.gameResult()).hasSameElementsAs(expected);
        assertThat(race.isEnded()).isTrue();

        race.process();
        assertThat(race.gameResult()).hasSameElementsAs(expected);
        assertThat(race.isEnded()).isTrue();
    }

    @ParameterizedTest(name = "check max position: {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void maxPosition(Cars cars, Turns turns) {
        final Race race = Race.of(cars, turns);
        for (int i = 0; !race.isEnded(); i++) {
            assertThat(race.maxPosition().toInt()).isEqualTo(i);
            race.process();
            assertThat(race.maxPosition().toInt()).isEqualTo(i + 1);
        }
    }

    static Stream<Arguments> parseCheckWinnerArguments() {
        final Car TEST_CAR_0 = Car.of(Name.of("test0"), ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_1 = Car.of(Name.of("test1"), NEVER_MOVE_POLICY);
        final Car TEST_CAR_2 = Car.of(Name.of("test2"), ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_3 = Car.of(Name.of("test3"), NEVER_MOVE_POLICY);
        final Car TEST_CAR_4 = Car.of(Name.of("test4"), ALWAYS_MOVE_POLICY);
        return Stream.of(
            Arguments.of(Cars.of(TEST_CAR_0, TEST_CAR_1), Turns.of(1), List.of(TEST_CAR_0.name())),
            Arguments.of(Cars.of(TEST_CAR_2, TEST_CAR_3, TEST_CAR_4), Turns.of(1), List.of(TEST_CAR_2.name(), TEST_CAR_4.name()))
        );
    }

    @ParameterizedTest(name = "get winner after race is over with: {arguments}")
    @MethodSource("parseCheckWinnerArguments")
    public void checkWinner(Cars cars, Turns turns, List<Name> expectedWinner) {
        final Race race = Race.of(cars, turns);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.isEnded()).isTrue();
        assertThat(race.winners().stream()).hasSameElementsAs(expectedWinner);
    }

    @Test
    @DisplayName("failed to get winner caused the race is not over")
    public void attemptToCheckWinnerDuringTheRace() {
        final Race race = Race.of(testCarAsList(), Turns.of(1));
        assertThat(race.isEnded()).isFalse();
        assertThatIllegalStateException().isThrownBy(race::winners);
    }
}
