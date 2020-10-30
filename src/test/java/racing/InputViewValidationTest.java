package racing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewValidationTest {

    // 1 이상 ~ 20 미만의 숫자만 입력할 수 있습니다
    public static final Pattern PATTERN = Pattern.compile("^[1-9]|1\\d$");

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

    private static boolean isMatch(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }
}
