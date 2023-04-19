package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    @DisplayName("4단계 - 자동차 경주(합우승자) - 자동차 이름에 null 또는 공백을 입력한 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @ParameterizedTest(name = "testValue : {0}")
    @NullAndEmptySource
    void pass_null_or_blank_name_value_illegal_argument_exception(String name) {
        assertThatThrownBy(() -> InputValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 null 또는 공백일 수 없습니다.");
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 자동차 이름이 5자를 초과하는 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @Test
    void pass_greater_than_5_letters_name_value_illegal_argument_exception() {
        assertThatThrownBy(() -> InputValidator.validateCarName("다섯글자초과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("4단계 - 자동차 경주(우승자) - 자동차 이름이 5자 이하인 경우 예외가 발생하지 않는지 확인")
    @Test
    void pass_less_than_or_equal_to_5_letters_name_value_illegal_argument_exception() {
        assertThatCode(() -> InputValidator.validateCarName("다섯글자다"))
                .doesNotThrowAnyException();
    }
}
