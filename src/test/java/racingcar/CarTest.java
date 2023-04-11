package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @DisplayName("4이상일 경우 거리 1 증가")
    @Test
    void move() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @DisplayName("4미만일 경우 값 그대로")
    @Test
    void stop() {
        Car car = new Car();
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 생성시_distace() {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
