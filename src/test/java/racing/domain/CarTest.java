package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("random 값 >= 4일 경우 전진할 수 있다")
    void go_forward_test() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition() > 1);
    }

    @Test
    @DisplayName("위치 최댓값을 구할 수 있다")
    void max_position() {
        Car car = new Car("pobi", 5);
        assertThat(car.max(3)).isEqualTo(5);
        assertThat(car.max(10)).isEqualTo(10);
    }

    @Test
    @DisplayName("최댓값과 일치 여부를 판별할 수 있다")
    void match_max_postiion() {
        Car car = new Car("pobi", 5);
        assertThat(car.max(3)).isEqualTo(5);
        assertThat(car.isMatch(5));
    }

    @Test
    @DisplayName("차 이름을 입력하지 않을 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carName_null() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_BLANK_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("5자 이상의 이름을 입력할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carName_length() {
        assertThatThrownBy(() -> new Car("HarryPorter"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_LENGTH_VALIDATION_ERROR);
    }

}
