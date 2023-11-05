package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.ExceedNameSizeException;

class NameTest {

    @Test
    @DisplayName("실패 - 자동차 이름을 5자 초과 하여 입력시 예외가 발생한다.")
    void fail_car_name_size() {
        // given
        String carName = "abcdef";

        // when & then
        Assertions.assertThatThrownBy(() -> new Name(carName))
                .isInstanceOf(ExceedNameSizeException.class)
                .hasMessage("자동차의 이름은 5자 이하만 입력 가능합니다.");
    }

}