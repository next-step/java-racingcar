package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤값이 4 미만인 경우, 자동차는 움직이지 않음")
    void move_under_four__ShouldNotMove() {
        // given
        CarMovementStrategy carMovementStrategy = () -> false;
        Car car = new Car(carMovementStrategy);

        // when
        car.move();

        // then
        assertThat(car.getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜던값이 4이상인 경우, 자동차는 움직임")
    void move_above_four__ShouldMove() {
        // given
        CarMovementStrategy carMovementStrategy = () -> true;
        Car car = new Car(carMovementStrategy);

        // when
        car.move();

        // then
        assertThat(car.getScore()).isEqualTo(1);
    }

}
