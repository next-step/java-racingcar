package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    final Car car = new Car();

    @Test
    @DisplayName("이동 조건이 충족되면 1번 움직인다.")
    void move_01() {
        // when
        car.move(() -> true);

        // then
        assertThat(car.position().value()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 조건이 충족되지 않으면 움직이지 않는다.")
    void move_02() {
        // when
        car.move(() -> false);

        // then
        assertThat(car.position().value()).isEqualTo(0);
    }

}
