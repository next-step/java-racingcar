package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 리스트를 생성하고 길이를 확인한다.")
    void makeCarList() {

        // given
        int carSize = 5;

        // when
        Cars cars = new Cars(5);

        // then
        assertThat(cars.getCarList().size()).isEqualTo(carSize);
    }

}