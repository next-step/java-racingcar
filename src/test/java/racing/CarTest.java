package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void test_car_initial_state() {
        Car car = new Car("car");
        assertThat(car.getMoves()).isEqualTo(0);
    }

    @Test
    void test_car_with_long_name() {
        assertThatThrownBy(() -> new Car("long-name")).isInstanceOf(CarNameTooLongException.class);
    }

    @Test
    void test_car_try_move_with_fail() {
        Car car = new Car("car");
        car.tryMove(() -> false);
        assertThat(car.getMoves()).isEqualTo(0);
    }

    @Test()
    void test_car_try_move_with_success() {
        Car car = new Car("car");
        car.tryMove(() -> true);
        assertThat(car.getMoves()).isEqualTo(1);
    }
}
