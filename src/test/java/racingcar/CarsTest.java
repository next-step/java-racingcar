package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 대수를 입력하면 입력한 만큼의 자동차 객체를 생성한다.")
    @Test
    void createCarsTest() {
        // given
        int carCount = 5;

        // when
        Cars cars = Cars.createCars(carCount);

        // then
        assertThat(cars.getCars().size()).isEqualTo(carCount);
    }

}