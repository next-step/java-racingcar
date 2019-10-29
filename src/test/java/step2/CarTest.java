package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car carAtZeroLocation;

    @BeforeEach
    void before() {
        carAtZeroLocation = new Car("i'm a car");
    }

    @Test
    void goForward() {
        final Car car = carAtZeroLocation.goForward();

        assertThat(car.current()).isEqualTo(1);
    }

    @Test
    void goForwardMany() {
        final Car car = carAtZeroLocation.goForward(10);

        assertThat(car.current()).isEqualTo(10);
    }
}