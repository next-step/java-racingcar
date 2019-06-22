package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @Test
    void move() {
        Car car = new Car();
        car.move(5L);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car();
        car.move(3L);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
