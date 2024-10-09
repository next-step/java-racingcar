package racinggame.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.racingcar.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarMovementTest {
    private static final int INIT_POSITION = 0;
    private static final int NUMBER_OF_ROUNDS = 4;

    @DisplayName("자동차 정지 테스트")
    @Test
    void stopRacingCar() {
        List<String> name = List.of("a");
        RacingCars racingCars = RacingCars.create(() -> false, name);
        racingCars.moveAll();

        Map<String, Integer> carInfo = racingCars.getCarsInfo();
        assertThat(carInfo.get("a")).isEqualTo(0);
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void moveRacingCar() {
        List<String> name = List.of("a");
        RacingCars racingCars = RacingCars.create(() -> true, name);
        racingCars.moveAll();

        Map<String, Integer> carInfo = racingCars.getCarsInfo();
        assertThat(carInfo.get("a")).isEqualTo(1);
    }

    @DisplayName("다중 이동 테스트")
    @Test
    void moveMultipleRacingCar() {
        List<String> name = List.of("a");
        RacingCars racingCars = RacingCars.create(() -> true, name);

        for (int i = 0; i < 5; i++) {
            racingCars.moveAll();
        }

        Map<String, Integer> carInfo = racingCars.getCarsInfo();
        assertThat(carInfo.get("a")).isEqualTo(5);
    }

    @DisplayName("다중 자동차 테스트")
    @Test
    void testMultipleCars() {
        MoveStrategy randomMove = new RandomMoveStrategy();
        List<String> names = Arrays.asList("a", "b", "c");
        RacingCars racingCars = RacingCars.create(randomMove, names);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            racingCars.moveAll();
        }

        Map<String, Integer> carInfo = racingCars.getCarsInfo();

        assertThat(carInfo.get("a")).isBetween(INIT_POSITION, NUMBER_OF_ROUNDS);
        assertThat(carInfo.get("b")).isBetween(INIT_POSITION, NUMBER_OF_ROUNDS);
        assertThat(carInfo.get("c")).isBetween(INIT_POSITION, NUMBER_OF_ROUNDS);
    }
}
