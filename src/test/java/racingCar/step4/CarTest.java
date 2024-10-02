package racingCar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차의 이름은 5자 초과하여 입력할 수 없다")
    @Test
    void validateCarNameSize(){
        assertThatThrownBy(() -> new Car("자동차이름5자초과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 입력 가능합니다");
    }
}