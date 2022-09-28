package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("moveForward() 메서드 파라미터가 true 면 location 한 칸 증가한다")
    void move_when_isMove_true() {
        Car car = new Car("suchan");
        car.moveForward(true);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 빈 값이나 null이 입력될 수 없다")
    void car_name_validate_nullOrEmpty(String nullAndEmpty) {
        assertThatThrownBy(() ->
                new Car(nullAndEmpty))
                .isInstanceOf(IllegalArgumentException.class);
    }
}