package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void car_1회_이동() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void car_정지() {
        Car car = new Car();
        car.stop();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 상태를 문자 '-'반복하여 반환한다.")
    void car_현재상태() {
        Car car = new Car();
        car.move();
        car.move();
        assertThat(car.showStatus()).isEqualTo("--");
    }
}
