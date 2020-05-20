package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("위치를 지정하지 않은 자동차의 위치는 0이다")
    @Test
    void newCar_Then_positionIs0() {
        Car car = new Car("car");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 전진한다")
    @Test
    void move() {
        Car car = new Car("car");
        Car movedCar = car.move();
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }
}
