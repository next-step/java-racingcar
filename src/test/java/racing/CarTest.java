package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName(value = "랜덤 값이 4이상이면, 전진")
    @Test
    void forwardMove() {
        // given
        Car car = new Car(0);

        // when
        car.move(() -> true);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName(value = "랜덤 값이 4미만이면, 정지")
    @Test
    void stopMove() {
        // given
        Car car = new Car(0);

        // when
        car.move(() -> false);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}