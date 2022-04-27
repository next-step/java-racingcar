package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.exception.GameException;

public class CarTest {
    @DisplayName("자동차이름은 5글자를 초과할 수 없다.")
    @Test
    void name_length() {
        assertThatThrownBy(() -> new Car("solari", Location.defaultLocation()))
                .isInstanceOf(GameException.class)
                .hasMessageContaining("length");
    }

    @DisplayName("전진 조건이 맞으면 전진한다.")
    @Test
    void run_if_condition_true() {
        Car car = new Car("solar");
        final Location beforeLocation = car.getLocation();

        car.run(() -> true);

        final Location afterLocation = car.getLocation();
        assertThat(beforeLocation).isNotEqualTo(afterLocation);
    }

    @DisplayName("전진 조건이 맞지않으면 전진하지 않는다.")
    @Test
    void no_run_if_condition_false() {
        Car car = new Car("solar");
        final Location beforeLocation = car.getLocation();

        car.run(() -> false);

        final Location afterLocation = car.getLocation();
        assertThat(beforeLocation).isEqualTo(afterLocation);
    }
}
