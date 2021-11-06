package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    @DisplayName("입력된 값이 null혹은, 빈값일 경우 예외발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessage("공백은 입력할 수 없습니다.");
    }

    @DisplayName("입력값이 0일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = "0")
    void validateZero(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessage("입력값은 1이상으로 입력해주세요.");
    }

    @DisplayName("입력값이 일반 문자열일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"문자열1", "입력값입니다.", "잘못 입력했어요.", "숫자가 아닙니다."})
    void validateString(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessage("회수를 입력해주세요.");
    }
}