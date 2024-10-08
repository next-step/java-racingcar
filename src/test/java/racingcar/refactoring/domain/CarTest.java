package racingcar.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class CarTest {

    private static final int MOVABLE_NUMBER = 4;
    private static final int STOP_NUMBER = 1;

    @Test
    void car_두칸_이동() {
        Car car = new Car("joon");
        car.moveForward(() -> true);
        car.moveForward(() -> true);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void car_정지() {
        Car car = new Car("joon");
        car.moveForward(() -> false);
        car.moveForward(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void car_이름반환() {
        Car car = new Car("Joon");
        assertThat(car.getName()).isEqualTo("Joon");
    }
}
