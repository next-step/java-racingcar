package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("전진 조건이 맞으면 전진한다.")
    @Test
    void run_if_condition_true() {
        Rule rule = () -> true;
        Car car = new Car(rule);
        final Location beforeLocation = car.getLocation();

        car.run();

        final Location afterLocation = car.getLocation();
        assertThat(beforeLocation).isNotEqualTo(afterLocation);
    }

    @DisplayName("전진 조건이 맞지않으면 전진하지 않는다.")
    @Test
    void no_run_if_condition_false() {
        Rule rule = () -> false;
        Car car = new Car(rule);
        final Location beforeLocation = car.getLocation();

        car.run();

        final Location afterLocation = car.getLocation();
        assertThat(beforeLocation).isEqualTo(afterLocation);
    }
}
