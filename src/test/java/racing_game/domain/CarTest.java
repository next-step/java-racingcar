package racing_game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing_game.core.Positive;

class CarTest {

    @Test
    void create() {
        Car car = Car.create();
        assertThat(car).isNotNull();
    }

    @Test
    void move() {
        Car car = Car.create();
        car.move(() -> true);
        assertThat(car.getDistance()).isEqualTo(Positive.of(1));

        car.move(() -> false);
        assertThat(car.getDistance()).isEqualTo(Positive.of(1));
    }
}
