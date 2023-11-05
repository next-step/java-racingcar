package racingCar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("숫자가 이동 조건 보다 작다면 자동차는 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Car_이동조건_미충족(int value) {
        Car car = new Car();
        int initialPosition = car.getCurrentPosition();
        car.moveAttempt(value);
        int afterPosition = car.getCurrentPosition();
        assertThat(afterPosition).isEqualTo(initialPosition);
    }

    @DisplayName("숫자가 이동 조건 이상이라면 자동차는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 9})
    void Car_이동조건_충족(int value) {
        Car car = new Car();
        int initialPosition = car.getCurrentPosition();
        car.moveAttempt(value);
        int afterPosition = car.getCurrentPosition();
        assertThat(afterPosition).isEqualTo(initialPosition + car.MOVE_DISTANCE);
    }
}
