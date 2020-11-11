package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName(value = "랜덤 값이 4이상이면, 전진")
    @Test
    void forwardMove() {
        // given
        int randomNumber = 4;
        Car car = new Car();

        // when
        car.move(randomNumber);

        // then
        Assertions.assertThat(car.getTravelDistance()).isEqualTo(1);
    }

    @DisplayName(value = "랜덤 값이 4미만이면, 정지")
    @Test
    void stopMove() {
        // given
        int randomNumber = 3;
        Car car = new Car();

        // when
        car.move(randomNumber);

        // then
        Assertions.assertThat(car.getTravelDistance()).isEqualTo(0);
    }
}