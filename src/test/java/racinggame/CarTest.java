package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final String CAR_NAME = "Mercedes-Benz";

    @Test
    @DisplayName("이동 조건이 충족되면 1번 움직인다.")
    void move_01() {
        // given
        final Car car = new Car(CAR_NAME);

        // when
        car.move(() -> true);

        // then
        assertThat(car.position().value()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 조건이 충족되지 않으면 움직이지 않는다.")
    void move_02() {
        // given
        final Car car = new Car(CAR_NAME);

        // when
        car.move(() -> false);

        // then
        assertThat(car.position().value()).isEqualTo(0);
    }

}
