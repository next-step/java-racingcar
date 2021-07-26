package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.createWithName("pobi");
    }

    @Test
    void constructor() {
        Car expected = Car.createWithNameAndPosition("pobi", 0);
        assertThat(car).isEqualTo(expected);
    }

    @Test
    void move() {
        Car expected = Car.createWithNameAndPosition("pobi", 1);
        assertThat(car.move(() -> true)).isEqualTo(expected);
    }

    @Test
    void stop() {
        Car expected = Car.createWithNameAndPosition("pobi", 0);
        assertThat(car.move(() -> false)).isEqualTo(expected);
    }
}
