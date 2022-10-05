package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void basic_engine_move() {
        Car car = new Car();
        car.setEngine(new BasicEngine(-1));
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void basic_engine_dont_move() {
        Car car = new Car();
        car.setEngine(new BasicEngine(10));
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
