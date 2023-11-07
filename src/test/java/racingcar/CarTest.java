package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차 이동 - 자동차가 이동한다. 이동 카운트가 증가한다")
    void move_car() {
        Car car = new Car();
        car.move();

        assertThat(car.moveCount()).isEqualTo(2);
    }
}