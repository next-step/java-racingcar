package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("입력한 자동차 개수에 맞춰 Cars가 구성된다")
    @Test
    void testCreateCar() {
        int carCount = 3;

        Cars cars = new Cars(carCount);

        assertThat(cars.isCarCount(carCount)).isTrue();
    }
}