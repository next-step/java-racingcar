package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    @DisplayName("자동차의 초기 위치는 0이다.")
    void carPositionTest() {
        Car car = new Car();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void carMoveTest() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
