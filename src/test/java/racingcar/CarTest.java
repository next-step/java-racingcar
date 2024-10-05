package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차를 생성하면 위치가 0인 자동차가 생성된다.")
    @Test
    void createCarTest() {
        // given // when
        Car car = Car.createCar(CarName.of("pobi"));

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }

    @DisplayName("CarEngine이 충분한 힘을 제공하면 자동차의 위치가 1 증가한다.")
    @Test
    void carMoveTestWithEnoughPower() {
        // given
        Car car = Car.createCar(CarName.of("pobi"));

        // when
        car.move((defaultMoveEnergy) -> true);

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @DisplayName("CarEngine이 충분한 힘을 제공하지 않으면 자동차의 위치는 변화하지 않는다.")
    @Test
    void carMoveTestWithNotEnoughPower() {
        // given
        Car car = Car.createCar(CarName.of("pobi"));

        // when
        car.move((defaultMoveEnergy) -> false);

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }
}