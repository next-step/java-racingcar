package study.retry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retry.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test", 0);
    }

    @Test
    void carEqualsTest() {
        Car car = new Car("test", 0);
        assertThat(this.car.equals(car)).isTrue();
    }

    @Test
    void getPositionDistanceForRandom() {
        Car carWithPosition = car.move(() -> true);
        assertThat(carWithPosition).isEqualTo(car);
    }
}
