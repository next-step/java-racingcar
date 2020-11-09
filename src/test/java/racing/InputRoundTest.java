package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static common.ErrorMessage.INVALID_VALUE;
import static common.ErrorMessage.NOT_NULL;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racing.view.InputValidator.ROUND_PATTERN;
import static racing.view.InputValidator.validate;

public class InputRoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10", "19"})
    @DisplayName("입력한 숫자가 정규표현식과 일치하는지 확인합니다")
    public void inputNumberTest(String input) {
        doesNotThrow(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    @DisplayName("숫자 0이 정규표현식과 일치하는 않는지 확인합니다")
    public void inputZeroTest(String input) {
        throwIllegalArgumentException(input, INVALID_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20, 30, 100"})
    @DisplayName("20 이상의 숫자가 정규표현식과 일치하는 않는지 확인합니다")
    public void inputOverTwentyTest(String input) {
        throwIllegalArgumentException(input, INVALID_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-15", "-2352"})
    @DisplayName("음수가 정규표현식과 일치하지 않는지 확인합니다")
    public void inputNegativeNumberTest(String input) {
        throwIllegalArgumentException(input, INVALID_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "English"})
    @DisplayName("글자가 정규표현식과 일치하지 않는지 확인합니다")
    public void inputNotNumberTest(String input) {
        throwIllegalArgumentException(input, INVALID_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열이 정규표현식과 일치하지 않는지 확인합니다")
    public void isBlankTest(String input) {
        throwIllegalArgumentException(input, INVALID_VALUE);
    }

    @Test
    @DisplayName("null 체크가 제대로 동작하는지 확인합니다")
    public void isNullTest() {
        throwIllegalArgumentException(null, NOT_NULL);
    }

    private static void doesNotThrow(String input) {
        assertThatCode(() -> validate(input, ROUND_PATTERN))
                .doesNotThrowAnyException();
    }

    private static void throwIllegalArgumentException(String input, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validate(input, ROUND_PATTERN))
                .withMessage(message);
    }
}
