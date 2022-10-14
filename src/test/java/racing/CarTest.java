package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void test_initial_state() {
        Car car = new Car("car");
        assertThat(car.getDistance()).isEqualTo(new CarDistance(0));
    }

    @Test
    void test_try_move_with_fail() {
        Car car = new Car("car");
        car.tryMove(() -> false);
        assertThat(car.getDistance()).isEqualTo(new CarDistance(0));
    }

    @Test
    void test_try_move_with_success() {
        Car car = new Car("car");
        car.tryMove(() -> true);
        assertThat(car.getDistance()).isEqualTo(new CarDistance(1));
    }

    @Test
    void test_has_distance() {
        Car car = new Car("car");
        assertThat(car.hasDistance(new CarDistance(0))).isTrue();
        assertThat(car.hasDistance(new CarDistance(1))).isFalse();
    }
}
