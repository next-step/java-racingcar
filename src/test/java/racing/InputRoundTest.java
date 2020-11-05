package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racing.view.InputValidator.ROUND_PATTERN;
import static racing.view.InputValidator.isNull;

import racing.view.InputValidator;

public class InputRoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10", "19"})
    @DisplayName("입력한 숫자가 정규표현식과 일치하는지 확인합니다")
    public void inputNumberTest(String input) {
        assertTrue(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    @DisplayName("숫자 0이 정규표현식과 일치하는 않는지 확인합니다")
    public void inputZeroTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"20, 30, 100"})
    @DisplayName("20 이상의 숫자가 정규표현식과 일치하는 않는지 확인합니다")
    public void inputOverTwentyTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-15", "-2352"})
    @DisplayName("음수가 정규표현식과 일치하지 않는지 확인합니다")
    public void inputNegativeNumberTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "English"})
    @DisplayName("글자가 정규표현식과 일치하지 않는지 확인합니다")
    public void inputNotNumberTest(String input) {
        assertFalse(isMatch(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 문자열이 정규표현식과 일치하지 않는지 확인합니다")
    public void isBlankTest(String input) {
        assertFalse(isMatch(input));
    }

    @Test
    @DisplayName("null 체크가 제대로 동작하는지 확인합니다")
    public void isNullTest() {
        assertTrue(isNull(null));
    }

    private static boolean isMatch(String input) {
        return InputValidator.isMatch(ROUND_PATTERN, input);
    }
}
