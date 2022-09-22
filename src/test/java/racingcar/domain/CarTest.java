package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("기본 생성자로 생성 시 위치는 1이다.")
    @Test
    void createCar() {
        Car car = new Car();

        assertThat(car.position()).isEqualTo(1);
    }

    @DisplayName("생성 시 위치를 지정할 수 있다.")
    @Test
    void createCarWithPosition() {
        Car car = new Car(2);

        assertThat(car.position()).isEqualTo(2);
    }

    @DisplayName("위치가 음수인 경우 예외 발생")
    @Test
    void createCarWithNegativePosition() {
        assertThatThrownBy(() -> new Car(-1)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("여러 자동차를 등록한다.")
    @Test
    void createCars() {
        Cars cars = CarFactory.createCars(3);

        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차 이동 확인")
    @Test
    void move() {
        Car car = new Car();

        Car movedCar = car.move(() -> true);

        assertThat(movedCar.position()).isEqualTo(2);
    }
}
