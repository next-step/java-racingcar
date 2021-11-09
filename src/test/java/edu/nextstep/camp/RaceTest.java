package edu.nextstep.camp;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class RaceTest {
    private static final List<Car> TEST_CARS = Car.of(new String[]{"test0", "test1", "test2", "test3"}, ALWAYS_MOVE_POLICY);
    private static final int TEST_TURN = 1;
    private static final Car TEST_CAR_0 = Car.of("test0", ALWAYS_MOVE_POLICY);
    private static final Car TEST_CAR_1 = Car.of("test1", NEVER_MOVE_POLICY);

    @ParameterizedTest(name = "create race test: {arguments}")
    @ValueSource(ints = {1, 15, 12000})
    public void create(int turn) {
        final Race race = Race.of(TEST_CARS, turn);
        assertThat(race.numberOfCars()).isEqualTo(TEST_CARS.size());
        assertThat(race.totalTurns()).isEqualTo(turn);
    }

    @Test
    @DisplayName("get game result(initial status)")
    public void gameResult() {
        final Integer[] expected = new Integer[TEST_CARS.size()];
        Arrays.fill(expected, 0);
        final Race race = Race.of(TEST_CARS, 1);
        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
    }

    @Test
    @DisplayName("process game during given turns")
    public void process() {
        final Race race = Race.of(List.of(TEST_CAR_0), TEST_TURN);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.gameResult()).containsExactly(TEST_TURN);
        assertThat(race.isEnded()).isTrue();
        race.process();
        assertThat(race.gameResult()).containsExactly(TEST_TURN);
        assertThat(race.isEnded()).isTrue();
    }

    @Test
    @DisplayName("get winner after race is over")
    public void checkWinner() {
        final Race race = Race.of(List.of(TEST_CAR_0, TEST_CAR_1), TEST_TURN);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.isEnded()).isTrue();
        assertThat(race.winners()).containsExactly(TEST_CAR_0.name());
    }

    @Test
    @DisplayName("failed to get winner caused the race is not over")
    public void attemptToCheckWinnerDuringTheRace() {
        final Race race = Race.of(List.of(TEST_CAR_0), TEST_TURN);
        assertThat(race.isEnded()).isFalse();
        assertThatIllegalStateException().isThrownBy(race::winners);
    }
}
