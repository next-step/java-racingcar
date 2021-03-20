package step4;

import org.junit.jupiter.api.Test;
import step4.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void move() {
        Car car = new Car("pobi");
        car.move(() -> true);
        assertThat(car.distance()).isEqualTo(1);
    }

    @Test
    public void stop() {
        Car car = new Car("pobi");
        car.move(() -> false);
        assertThat(car.distance()).isEqualTo(0);
    }

    @Test
    void create() {
        assertThat(new Car("pobi", 2)).isEqualTo(new Car("pobi", 2));
    }
}