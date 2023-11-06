package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @DisplayName("경주의 최소 차량 조건을 충족한다.")
    @Test
    void Cars_경주조건_충족() {
        Cars cars = new Cars(Racing.MINIMUM_CAR_COUNT);
        assertThat(cars.carsReady(Racing.MINIMUM_CAR_COUNT)).isTrue();
    }
}