package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,10})
    @DisplayName("moveForward() 메서드 파라미터가 4 이상이면 location 한 칸 증가한다")
    void move_when_greater_than_three() {
        CarName carName = new CarName("suchan");
        Car car = new Car(carName);
        car.moveForward(4);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("moveForward() 메서드 파라미터가 4 미만이면 location 증가하지 않는다")
    void dont_move_less_than_four(int input) {
        CarName carName = new CarName("suchan");
        Car car = new Car(carName);
        car.moveForward(input);
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 빈 값이나 null이 입력될 수 없다")
    void car_name_validate_nullOrEmpty(String nullAndEmpty) {
        assertThatThrownBy(() ->
            new CarName(nullAndEmpty))
            .isInstanceOf(IllegalArgumentException.class);
    }
}