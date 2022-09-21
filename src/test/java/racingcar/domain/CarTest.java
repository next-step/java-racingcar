package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("기본 생성자로 생성 시 위치는 0이다.")
    @Test
    void createCar() {
        Car car = new Car();

        assertThat(car.position()).isEqualTo(0);
    }

    @DisplayName("생성 시 위치를 지정할 수 있다.")
    @Test
    void createCarWithPosition() {
        Car car = new Car(2);

        assertThat(car.position()).isEqualTo(2);
    }

    @DisplayName("자동차 이동 확인")
    @Test
    void move() {
        Car car = new Car();

        Car movedCar = car.move(() -> true);

        assertThat(movedCar.position()).isEqualTo(1);
        assertThat(movedCar.toString()).isEqualTo("-");
    }
}
