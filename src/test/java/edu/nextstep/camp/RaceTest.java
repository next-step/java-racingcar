package edu.nextstep.camp;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceTest {
    private static final String[] TEST_CARS = {"test0", "test1", "test2", "test3"};
    private static final int TEST_TURN = 1;

    static Stream<Arguments> parseIllegalArguments() {
        return Stream.of(
                Arguments.of(TEST_CARS, 0),
                Arguments.of(TEST_CARS, -1),
                Arguments.of(null, TEST_TURN),
                Arguments.of(new String[] {}, TEST_TURN),
                Arguments.of(new String[] {"test0", "test11"}, TEST_TURN)
        );
    }

    @ParameterizedTest(name = "create with invalid values: {arguments}")
    @MethodSource("parseIllegalArguments")
    public void createFail(String[] nameOfCars, int turn) {
        assertThatIllegalArgumentException().isThrownBy(() -> Race.of(nameOfCars, turn, RandomMovePolicy.getInstance()));
    }

    @ParameterizedTest(name = "create race test: {arguments}")
    @ValueSource(ints = {1, 15, 12000})
    public void create(int turn) {
        final Race race = Race.of(TEST_CARS, turn, RandomMovePolicy.getInstance());
        assertThat(race.numberOfCars()).isEqualTo(TEST_CARS.length);
        assertThat(race.totalTurns()).isEqualTo(turn);
    }

    @Test
    @DisplayName("get game result(initial status)")
    public void gameResult() {
        final Integer[] expected = new Integer[TEST_CARS.length];
        Arrays.fill(expected, 0);
        final Race race = Race.of(TEST_CARS, 1, RandomMovePolicy.getInstance());
        assertThat(race.gameResult()).isEqualTo(Arrays.asList(expected));
    }

    @Test
    @DisplayName("process game during given turns")
    public void process() {
        final int turns = 1;
        final String[] names = {TEST_CARS[0]};
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
