package stringcalculator;

import stringcalculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = StringCalculator.getInstance();

    @ParameterizedTest
    @DisplayName("들어온 문자열이 null일 때 Valid Test")
    @NullAndEmptySource
    void inputNullTest(String input) {
        assertThat(input == null || input.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열 내부에 blank가 존재할 때 Valid Test")
    @ValueSource(strings = {"", " ", "   "})
    void inputBlankTest(String input) {
        String trimInput = input.trim();
        assertThat(trimInput.isBlank()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열이 null일 때 변환 Test")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "        "})
    void inputNullProcessTest(String input) {
        String checkInput = stringCalculator.nullCheck(input) ? "0" : input ;
        assertThat(checkInput).isEqualTo("0");
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열 내부에 blank가 존재할 때 변환 Test")
    @ValueSource(strings = {"a    a", "b c", " a b "})
    void inputBlankProcessTest(String input) {
        String trimInput = stringCalculator.deleteBlank(input);
        assertThat(trimInput.contains(" ")).isFalse();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열이 한자리 숫자일 때 확인 Test")
    @ValueSource(strings = {"1", "2"})
    void inputNumericProcessTest(String input) {
        boolean isNumeric = stringCalculator.isNumeric(input);
        assertThat(isNumeric).isTrue();
    }

    @ParameterizedTest
    @DisplayName("들어온 문자열이 한자리 숫자가 아닐 때 확인 Test")
    @ValueSource(strings = {"22", "a", "a2"})
    void inputNotNumericProcessTest(String input) {
        boolean isNumeric = stringCalculator.isNumeric(input);
        assertThat(isNumeric).isFalse();
    }

    @ParameterizedTest
    @DisplayName("음수 split 확인 Test")
    @ValueSource(strings = {"-1:1:1", "-1,2", "1:-1", "2:1:-1"})
    void minusNumberSplitTest(String input) {
        String[] arrays = input.split(",|:");
        assertThat(arrays).contains("-1");
    }

}
