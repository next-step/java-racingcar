package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    public static final int STOP_NUMBER = 3;
    public static final int MOVABLE_NUMBER = 8;

    @Test
    void car_1회_이동() {
        Car car = new Car();
        car.moveForward(MOVABLE_NUMBER);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void car_정지() {
        Car car = new Car();
        car.moveForward(STOP_NUMBER);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 현재 위치를 반환한다.")
    void car_현재위치() {
        Car car = new Car();
        car.moveForward(MOVABLE_NUMBER);
        car.moveForward(MOVABLE_NUMBER);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
