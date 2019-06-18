package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void move() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void moveWhenHigherThan4() {
        Car car = new Car();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
