package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 리스트를 생성하고 길이를 확인한다.")
    void makeCarList() {

        // given
        Cars cars = new Cars();
        int carSize = 5;

        // expected
        assertThat(cars.makeCarList(carSize).getCarList().size()).isEqualTo(carSize);
    }
}