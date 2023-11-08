package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("자동차를 생성하면 초기 위치는 0 이다.")
    @Test
    void Car_초기위치() {
        Car car = new Car(() -> true);
        assertThat(car.currentPosition()).isZero();
    }

    @DisplayName("자동차가 전진할수있다.")
    @Test
    void Car_전진() {
        Car car = new Car(() -> true);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(car.MOVE_DISTANCE);
    }

    @DisplayName("자동차가 멈춘다")
    @Test
    void Car_멈춤() {
        Car car = new Car(() -> false);
        car.move();
        assertThat(car.currentPosition()).isZero();
    }
}
