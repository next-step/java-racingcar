package racingcar.model;

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
}
