package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {

    @Test
    @DisplayName("moveForward() 메서드 호출 시 location 한 칸 증가한다")
    void moveForward() {
        CarName carName = new CarName("suchan");
        Car car = new Car(carName);
        car.moveForward();
        assertThat(car.getLocation()).isEqualTo(1);
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