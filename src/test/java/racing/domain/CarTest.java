package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void create() {
        car = new Car();
    }

    @Test
    void move_getPosition() {
        car.move(true);
        car.move(true);
        car.move(false);
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }
}