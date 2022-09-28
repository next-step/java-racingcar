package racinggame.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.exception.InvalidCarNameException;

class CarTest {

    @Test
    @DisplayName("전진 가능 연료량인 4 이상의 연료를 주입할 경우 전진 성공")
    void move_car_success() {
        Car car = new Car("Name");
        int beforeDistance = car.getDistance();
        final int possibleMoveFuel = 8;

        car.move(possibleMoveFuel);

        assertThat(car.getDistance()).isEqualTo(beforeDistance + 1);
    }

    @Test
    @DisplayName("전진 가능 연료량인 4 미만의 연료를 주입할 경우 전진 실패하는 테스트")
    void move_car_fail() {
        Car car = new Car("Name");
        int beforeDistance = car.getDistance();
        final int impossibleMoveFuel = 3;

        car.move(impossibleMoveFuel);

        assertThat(car.getDistance()).isEqualTo(beforeDistance);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "looooooongname"})
    @DisplayName("0자 혹은 5자 초과의 이름을 등록하면 예외 발생.")
    void fail_to_register_empty_name_car(String carName) {
        assertThatThrownBy(() -> new Car((carName)))
                .isInstanceOf(InvalidCarNameException.class);
    }

}
