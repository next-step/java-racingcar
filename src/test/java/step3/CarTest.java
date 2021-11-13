package step3;

import org.junit.jupiter.api.Test;
import step3.domain.entity.Car;
import step3.domain.value.Location;
import step3.movingstrategy.InputMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        final Car car = new Car();
        assertThat(car.play(new InputMovingStrategy(4)))
                .isEqualTo(new Location(1));
    }

    @Test
    void stay() {
        final Car car = new Car();
        assertThat(car.play(new InputMovingStrategy(3)))
                .isEqualTo(new Location(0));
    }
}
