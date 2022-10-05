package game.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 이동_가능() {
        Car car = new Car("a");

        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 이동_불가능() {
        Car car = new Car("a");

        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

}
