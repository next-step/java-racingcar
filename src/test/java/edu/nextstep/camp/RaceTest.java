package edu.nextstep.camp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class RaceTest {
    static Turn testTurn() {
        return Turn.of(1);
    }

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
                Arguments.of(testCarAsList(), Turn.of(1)),
                Arguments.of(testCarAsList(), Turn.of(15)),
                Arguments.of(testCarAsList(), Turn.of(1000)),
                Arguments.of(testCars(), Turn.of(1)),
                Arguments.of(testCars(), Turn.of(15)),
                Arguments.of(testCars(), Turn.of(1000))
        );
    }

    @ParameterizedTest(name = "create race test: {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void create(Cars cars, Turn turn) {
        final Race race = Race.of(cars, turn);
        assertThat(race.numberOfCars()).isEqualTo(cars.size());
        assertThat(race.totalTurns()).isEqualTo(turn.total());
    }

    static Stream<Arguments> parseIllegalArgumentsOfRace() {
        return Stream.of(
                Arguments.of(null, testTurn()),
                Arguments.of(testCars(), null)
        );
    }

    @ParameterizedTest(name = "failed to create race: {arguments}")
    @MethodSource("parseIllegalArgumentsOfRace")
    public void createFailed(Cars cars, Turn turn) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(cars, turn));
    }

    @ParameterizedTest(name = "get game result(initial status): {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void gameResult(Cars cars, Turn turn) {
        final Integer[] expected = new Integer[cars.size()];
        Arrays.fill(expected, 0);
        final Race race = Race.of(cars, turn);
        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
    }

    @ParameterizedTest(name = "process game during given turns: {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void process(Cars cars, Turn turn) {
        final Race race = Race.of(cars, turn);
        final Integer[] expected = new Integer[cars.size()];
        Arrays.fill(expected, turn.total());
        assertThat(race.isEnded()).isFalse();

        while (!race.isEnded()) {
            race.process();
        }

        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
        assertThat(race.isEnded()).isTrue();

        race.process();
        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
        assertThat(race.isEnded()).isTrue();
    }

    @ParameterizedTest(name = "check max position: {arguments}")
    @MethodSource("parseValidRaceArguments")
    public void maxPosition(Cars cars, Turn turn) {
        final Race race = Race.of(cars, turn);
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
            Arguments.of(Cars.of(TEST_CAR_0, TEST_CAR_1), testTurn(), List.of(TEST_CAR_0.name())),
            Arguments.of(Cars.of(TEST_CAR_2, TEST_CAR_3, TEST_CAR_4), testTurn(), List.of(TEST_CAR_2.name(), TEST_CAR_4.name()))
        );
    }

    @ParameterizedTest(name = "get winner after race is over with: {arguments}")
    @MethodSource("parseCheckWinnerArguments")
    public void checkWinner(Cars cars, Turn turn, List<Name> expectedWinner) {
        final Race race = Race.of(cars, turn);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.isEnded()).isTrue();
        assertThat(race.winners().stream()).hasSameElementsAs(expectedWinner);
    }

    @Test
    @DisplayName("failed to get winner caused the race is not over")
    public void attemptToCheckWinnerDuringTheRace() {
        final Race race = Race.of(testCarAsList(), testTurn());
        assertThat(race.isEnded()).isFalse();
        assertThatIllegalStateException().isThrownBy(race::winners);
    }
}
