package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차를 이름으로 생성할 수 있다")
    void create_car_by_name() {
        Car car = new Car("A");
        assertThat(car.name()).isEqualTo("A");
    }

    @Test
    @DisplayName("자동차를 이름이 5자리를 초과하면 예외가 발생한다")
    void create_car_by_name_and_name_length_less_then_5() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(RuntimeException.class);
    }
}