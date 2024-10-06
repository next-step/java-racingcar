package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차가 이동하는지 확인")
    void move() {
        Car car = new Car("truck");
        boolean isMove = true;
        car.move(isMove);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
