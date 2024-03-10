package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("RandomMovementStrategy의 movable이 false인 경우, 자동차는 움직이지 않음")
    void RandomMovementStrategy__ShouldNotMove() {
        // given
        CarMovementStrategy carMovementStrategy = () -> false;
        Car car = new Car(carMovementStrategy);

        // when
        car.move();

        // then
        assertThat(car.getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("RandomMovementStrategy의 movable이 true인 경우, 자동차는 움직임")
    void RandomMovementStrategy__ShouldMove() {
        // given
        CarMovementStrategy carMovementStrategy = () -> true;
        Car car = new Car(carMovementStrategy);

        // when
        car.move();

        // then
        assertThat(car.getScore()).isEqualTo(1);
    }

}
