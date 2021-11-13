package step3;

import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.movingstrategy.InputMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        final Car car = new Car();
        car.play(new InputMovingStrategy(4));
        assertThat(car.location).isEqualTo(1);
    }

    @Test
    void stay() {
        final Car car = new Car();
        car.play(new InputMovingStrategy(3));
        assertThat(car.location).isEqualTo(0);
    }
}
