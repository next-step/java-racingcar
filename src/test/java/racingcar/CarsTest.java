package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 경주 리스트를 초기화한다")
    @Test
    void initialize() {
        Cars cars = Cars.initialize(3);

        assertThat(cars.currentCars().size()).isEqualTo(3);
        assertThat(cars.currentCars().get(0).currentPosition()).isEqualTo(0);
    }

    @DisplayName("다음 자동차 경주 리스트를 반환한다")
    @Test
    void next() {
        Cars cars = Cars.initialize(3);

        Cars nextCars = cars.next();

        assertThat(nextCars.currentCars().size()).isEqualTo(3);
    }
}