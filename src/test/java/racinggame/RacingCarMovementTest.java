package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.racingcar.RacingCars;
import racinggame.racingcar.RandomMoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarMovementTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
    }

    @DisplayName("자동차 정지 테스트")
    @Test
    void stopRacingCar() {
        racingCars.addCar(() -> false);
        racingCars.moveAll();

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        assertThat(positions).containsExactly(0);
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void moveRacingCar() {
        racingCars.addCar(() -> true);
        racingCars.moveAll();

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        assertThat(positions).containsExactly(1);
    }

    @DisplayName("다중 이동 테스트")
    @Test
    void moveMultipleRacingCar() {
        racingCars.addCar(() -> true);

        for (int i = 0; i < 5; i++) {
            racingCars.moveAll();
        }

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        assertThat(positions).containsExactly(5);
    }

    @DisplayName("다중 자동차 테스트")
    @Test
    void testMultipleCars() {
        racingCars.addCar(() -> true);  // 항상 움직임
        racingCars.addCar(() -> false); // 항상 멈춤
        racingCars.addCar(new RandomMoveStrategy()); // 실제 랜덤 전략 사용

        for (int i = 0; i < 4; i++) {
            racingCars.moveAll();
        }

        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();

        assertThat(positions.get(0)).isEqualTo(4);
        assertThat(positions.get(1)).isEqualTo(0);
        assertThat(positions.get(2)).isBetween(0, 4);
    }
}
