package edu.nextstep.camp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class RaceTest {
    private static final int TEST_TURN = 1;

    static Cars getTestCars() {
        return Cars.of(new String[]{"test0", "test1", "test2", "test3"}, ALWAYS_MOVE_POLICY);
    }

    static Cars getTestCarAsList() {
        return Cars.of(Car.of("test0", ALWAYS_MOVE_POLICY));
    }

    @ParameterizedTest(name = "create race test: {arguments}")
    @ValueSource(ints = {1, 15, 12000})
    public void create(int turn) {
        final Cars testCars = getTestCars();
        final Race race = Race.of(testCars, turn);
        assertThat(race.numberOfCars()).isEqualTo(testCars.size());
        assertThat(race.totalTurns()).isEqualTo(turn);
    }

    static Stream<Arguments> parseIllegalArgumentsOfRace() {
        return Stream.of(
                Arguments.of(null, TEST_TURN),
                Arguments.of(getTestCars(), 0),
                Arguments.of(getTestCars(), -1000)
        );
    }

    @ParameterizedTest(name = "failed to create race: {arguments}")
    @MethodSource("parseIllegalArgumentsOfRace")
    public void createFailed(Cars cars, int turn) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(cars, turn));
    }

    @Test
    @DisplayName("get game result(initial status)")
    public void gameResult() {
        final Cars testCars = getTestCars();
        final Integer[] expected = new Integer[testCars.size()];
        Arrays.fill(expected, 0);
        final Race race = Race.of(testCars, 1);
        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
    }

    @Test
    @DisplayName("process game during given turns")
    public void process() {
        final Race race = Race.of(getTestCarAsList(), TEST_TURN);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.gameResult()).containsExactly(TEST_TURN);
        assertThat(race.isEnded()).isTrue();
        race.process();
        assertThat(race.gameResult()).containsExactly(TEST_TURN);
        assertThat(race.isEnded()).isTrue();
    }

    static Stream<Arguments> parseCheckWinnerArguments() {
        final Car TEST_CAR_0 = Car.of("test0", ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_1 = Car.of("test1", NEVER_MOVE_POLICY);
        final Car TEST_CAR_2 = Car.of("test2", ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_3 = Car.of("test3", NEVER_MOVE_POLICY);
        final Car TEST_CAR_4 = Car.of("test4", ALWAYS_MOVE_POLICY);
        return Stream.of(
            Arguments.of(Cars.of(TEST_CAR_0, TEST_CAR_1), TEST_TURN, List.of(TEST_CAR_0.name())),
            Arguments.of(Cars.of(TEST_CAR_2, TEST_CAR_3, TEST_CAR_4), TEST_TURN, List.of(TEST_CAR_2.name(), TEST_CAR_4.name()))
        );
    }

    @ParameterizedTest(name = "get winner after race is over with: {arguments}")
    @MethodSource("parseCheckWinnerArguments")
    public void checkWinner(Cars cars, int turn, List<String> expectedWinner) {
        final Race race = Race.of(cars, turn);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.isEnded()).isTrue();
        assertThat(race.winners()).hasSameElementsAs(expectedWinner);
    }

    @Test
    @DisplayName("failed to get winner caused the race is not over")
    public void attemptToCheckWinnerDuringTheRace() {
        final Race race = Race.of(getTestCarAsList(), TEST_TURN);
        assertThat(race.isEnded()).isFalse();
        assertThatIllegalStateException().isThrownBy(race::winners);
    }
}
