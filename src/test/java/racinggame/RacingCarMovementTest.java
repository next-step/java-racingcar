package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.racingcar.RacingCars;
import racinggame.racingcar.RandomMoveStrategy;
import racinggame.racingcar.MoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarMovementTest {
    private static final int INIT_POSITION = 0;
    private static final int NUMBER_OF_ROUNDS = 4;

    @DisplayName("자동차 정지 테스트")
    @Test
    void stopRacingCar() {
        List<String> name = List.of("a");
        RacingCars racingCars = RacingCars.create(1, () -> false, name);
        racingCars.moveAll();

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        assertThat(positions).containsExactly(0);
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void moveRacingCar() {
        List<String> name = List.of("a");
        RacingCars racingCars = RacingCars.create(1, () -> true, name);
        racingCars.moveAll();

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        assertThat(positions).containsExactly(1);
    }

    @DisplayName("다중 이동 테스트")
    @Test
    void moveMultipleRacingCar() {
        List<String> name = List.of("a");
        RacingCars racingCars = RacingCars.create(1, () -> true, name);

        for (int i = 0; i < 5; i++) {
            racingCars.moveAll();
        }

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        assertThat(positions).containsExactly(5);
    }

    @DisplayName("다중 자동차 테스트")
    @Test
    void testMultipleCars() {
        MoveStrategy randomMove = new RandomMoveStrategy();
        List<String> names = Arrays.asList("a", "b", "c");
        RacingCars racingCars = RacingCars.create(3, randomMove, names);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            racingCars.moveAll();
        }

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();

        assertThat(positions.get(0)).isBetween(INIT_POSITION, NUMBER_OF_ROUNDS);
        assertThat(positions.get(1)).isBetween(INIT_POSITION, NUMBER_OF_ROUNDS);
        assertThat(positions.get(2)).isBetween(INIT_POSITION, NUMBER_OF_ROUNDS);
    }
}
