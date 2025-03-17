import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void move() {
        final Car car = new Car();
        final int position = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isBetween(position, position + 1);
    }
}
