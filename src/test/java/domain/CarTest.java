package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void init_car() {
        Car car = new Car();
        assertThat(car.getMileage()).isEqualTo(0);
    }

    @Test
    public void check_if_move_1_mile() {
        Car car = new Car();
        car.move();
        assertThat(car.getMileage()).isEqualTo(1);
        car.move();
        assertThat(car.getMileage()).isEqualTo(2);
    }
}
