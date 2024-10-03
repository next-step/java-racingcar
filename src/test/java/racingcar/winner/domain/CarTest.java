package racingcar.winner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int MOVABLE_NUMBER = 4;
    private static final int STOP_NUMBER = 1;

    @Test
    void car_두칸_이동() {
        Car car = new Car("joon");
        car.moveForward(MOVABLE_NUMBER);
        car.moveForward(MOVABLE_NUMBER);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void car_정지() {
        Car car = new Car("joon");
        car.moveForward(STOP_NUMBER);
        car.moveForward(STOP_NUMBER);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void car_이름반환() {
        Car car = new Car("Joon");
        assertThat(car.getName()).isEqualTo("Joon");
    }
}
