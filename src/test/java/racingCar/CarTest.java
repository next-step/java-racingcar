package racingCar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차를 생성하면 초기 위치는 0 이다.")
    @Test
    void Car_초기위치() {
        Car car = new Car();
        assertThat(0).isEqualTo(car.getCurrentPosition());
    }

    @DisplayName("자동차가 전진할수있다.")
    @Test
    void Car_전진() {
        Car car = new Car();
        int initialPosition = car.getCurrentPosition();
        car.moveForward();
        int afterPosition = car.getCurrentPosition();
        assertThat(afterPosition).isEqualTo(initialPosition + car.MOVE_DISTANCE);
    }
}
