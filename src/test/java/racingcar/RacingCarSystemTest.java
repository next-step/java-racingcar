package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarSystemTest {

    @Test
    @DisplayName("경주 시스템 자동차 등록")
    void numberOfCar() {
        int cars = 3;

        RacingCarSystem system = new RacingCarSystem();
        system.registerCar(cars);

        assertThat(system.getNumberOfCars()).isEqualTo(cars);
    }

    @Test
    @DisplayName("경주 시스템 횟수 등록")
    void movements() {
        int movements = 5;

        RacingCarSystem system = new RacingCarSystem();
        system.registerMovements(movements);

        assertThat(system.getMovements()).isEqualTo(movements);
    }

    @Test
    @DisplayName("자동차 경주 3대 1회")
    void racing() {
        int cars = 3;
        int movements = 5;

        RacingCarSystem system = new RacingCarSystem();
        system.registerCar(cars);
        system.registerMovements(movements);

        system.goOrStop();

        int[] distanceOfCars = system.getStatusOfCars();
        assertThat(distanceOfCars).contains(0);
        assertThat(distanceOfCars).contains(1);
    }

}
