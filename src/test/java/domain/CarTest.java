package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차는_움직인다() {
        Car car = new Car();
        MovingStrategy movingStrategy = new MovingStrategy();
        car.move(true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_움직이지_않는다() {
        Car car = new Car();
        MovingStrategy movingStrategy = new MovingStrategy();
        car.move(false);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}