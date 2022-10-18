package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void testForward() {
        Car car = new Car();

        car.forward();
        car.forward();
        car.forward();

        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void testNameLength() {
        assertThatThrownBy(() -> new Car("over5LengthName"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
