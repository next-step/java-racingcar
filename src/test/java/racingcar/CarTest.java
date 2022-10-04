package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Car.MOVE_DISTANCE;

public class CarTest {
    @Test
    @DisplayName("자동차는 한 번에 정해진 거리만큼 전진할 수 있다")
    void moveForward() {
        Car car = Car.from(0);
        car.moveForward();
        assertThat(car).isEqualTo(Car.from(MOVE_DISTANCE));
    }
}
