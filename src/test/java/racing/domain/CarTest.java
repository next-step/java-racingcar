package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;
    @BeforeEach
    void beforeEach() {
        car = new Car("자동차1");
    }

    @Test
    void name() {
        assertThat(car.getName()).isEqualTo("자동차1");
    }

    @Test
    void go() {
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void move() {
        car.move(1);
        car.move(0);
        car.move(1);
        car.move(1);
        car.move(0);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
