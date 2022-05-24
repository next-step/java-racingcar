package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("전진 조건이 맞으면 전진한다.")
    @Test
    void run_if_condition_true() {
        Car car = new Car("solar", new Location(1));

        car.run(() -> true);

        Car expected = new Car("solar", new Location(2));
        assertThat(car).isEqualTo(expected);
    }

    @DisplayName("전진 조건이 맞지않으면 전진하지 않는다.")
    @Test
    void no_run_if_condition_false() {
        Car car = new Car("solar", new Location(1));

        car.run(() -> false);

        Car expected = new Car("solar", new Location(1));
        assertThat(car).isEqualTo(expected);
    }
}
