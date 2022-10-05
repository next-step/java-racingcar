package racingcar;


import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarErrorCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Car.MOVE_DISTANCE;

public class CarTest {
    @Test
    @DisplayName("자동차는 한 번에 정해진 거리만큼 전진할 수 있다")
    void moveForward() {
        Car car = Car.from(0);
        car.moveForward();
        assertThat(car).isEqualTo(Car.from(MOVE_DISTANCE));
    }

    @Test
    @DisplayName("자동차는 이름을 가질 수 있다")
    void carName() {
        String name = "pobi";
        Car car = Car.from(name);
        assertThat(car).extracting("name").isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 이름은 정해진 길이를 초과할 수 없다")
    void carNameMaximumValue() {
        assertThatThrownBy(() -> Car.from("pobipobi"))
                .isInstanceOf(CustomException.class)
                .hasMessage(CarErrorCode.CAR_NAME_LENGTH_BAD_REQUEST.getMessage());
    }
}
