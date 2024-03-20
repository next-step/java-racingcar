package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        Car car = new Car();

        assertThat(car.getPosition()).isEqualTo(1);

        car.move();
    }
}
