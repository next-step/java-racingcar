package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void generate_car() {
        car = new Car("Car");
    }

    @Test
    void move_when_movable() {
        car.move(() -> true);
        assertThat(car.showPosition()).isEqualTo(1);
    }

    @Test
    void stop_when_not_movable() {
        car.move(() -> false);
        assertThat(car.showPosition()).isEqualTo(0);
    }
}