package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    @DisplayName("3단계 - 자동차 경주 - 자동차 이름에 null 을 입력한 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @Test
    void pass_null_name_value_illegal_argument_exception() {
        assertThatThrownBy(() -> InputValidator.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 null 또는 공백일 수 없습니다.");
    }

    @DisplayName("3단계 - 자동차 경주 - 자동차 이름에 공백 을 입력한 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @Test
    void pass_blank_name_value_illegal_argument_exception() {
        assertThatThrownBy(() -> InputValidator.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 null 또는 공백일 수 없습니다.");
    }
}
