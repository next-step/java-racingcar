package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차를 생성하면 위치가 0인 자동차가 생성된다.")
    @Test
    void createCarTest() {
        // given // when
        Car car = Car.createCar();

        // then
        Assertions.assertThat(car.getCurrentLocation()).isEqualTo(0);
    }

    @DisplayName("4 이상의 숫자가 주어지면 자동차의 위치가 1 증가한다.")
    @Test
    void carMoveTestWithEnoughPower() {
        // given
        Car car = Car.createCar();

        // when
        car.move(TestEngine.createCarEngine(4));

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @DisplayName("4 미만의 숫자가 주어지면 자동차의 위치는 변화하지 않는다.")
    @Test
    void carMoveTestWithNotEnoughPower() {
        // given
        Car car = Car.createCar();

        // when
        car.move(TestEngine.createCarEngine(3));

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }
}