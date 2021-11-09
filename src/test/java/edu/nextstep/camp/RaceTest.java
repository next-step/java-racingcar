package edu.nextstep.camp;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceTest {
    final String[] testCars = {"test0", "test1", "test2", "test3"};

    @ParameterizedTest(name = "create with invalid values: {arguments}")
    @ValueSource(ints = {0, -1})
    public void createFail(int turn) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(testCars, turn, RandomMovePolicy.getInstance()));
    }

    @ParameterizedTest(name = "create with invalid values: {arguments}")
    @NullAndEmptySource
    public void createFail(String[] nameOfCars) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(nameOfCars, 1, RandomMovePolicy.getInstance()));
    }

    @ParameterizedTest(name = "create with invalid values: {arguments}")
    @ValueSource(strings = "test-0")
    public void createFail(String nameOfCars) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(nameOfCars.split(nameOfCars), 1, RandomMovePolicy.getInstance()));
    }

    @ParameterizedTest(name = "create race test: {arguments}")
    @ValueSource(ints = {1, 15, 12000})
    public void create(int turn) {
        final Race race = Race.of(testCars, turn, RandomMovePolicy.getInstance());
        assertThat(race.numberOfCars()).isEqualTo(testCars.length);
        assertThat(race.totalTurns()).isEqualTo(turn);
    }


    @Test
    @DisplayName("get game result(initial status)")
    public void gameResult() {
        final Integer[] expected = new Integer[testCars.length];
        Arrays.fill(expected, 0);
        final Race race = Race.of(testCars, 1, RandomMovePolicy.getInstance());
        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
    }

    @Test
    @DisplayName("process game during given turns")
    public void process() {
        final int turns = 1;
        final String[] names = {testCars[0]};
        final Race race = Race.of(names, turns, TestMovePolicy.ALWAYS_MOVE_POLICY);
        assertThat(race.isEnded()).isFalse();
        race.process();
        assertThat(race.gameResult()).containsExactly(turns);
        assertThat(race.isEnded()).isTrue();
        race.process();
        assertThat(race.gameResult()).containsExactly(turns);
        assertThat(race.isEnded()).isTrue();
    }
}
