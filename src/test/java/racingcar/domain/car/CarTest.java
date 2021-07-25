package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void constructor() {
        assertThat(car).isEqualTo(new Car(0));
    }

    @Test
    void move() {
        assertThat(car.move(() -> true)).isEqualTo(new Car(1));
    }

    @Test
    void stop() {
        assertThat(car.move(() -> false)).isEqualTo(new Car());
    }
}
