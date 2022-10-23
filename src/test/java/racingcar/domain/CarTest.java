package racingcar.domain;


import exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.exception.CarErrorCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Car.MOVE_DISTANCE;

public class CarTest {

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

    @Test
    @DisplayName("자동차는 한번 움직일 때마다 정해진 거리만큼 전진한다")
    void move() {
        Car car = Car.from("pobi");
        car.moveForward();
        assertThat(car.getLocation()).isEqualTo(MOVE_DISTANCE);
    }
}
