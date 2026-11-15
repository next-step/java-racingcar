package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringSumCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열 입력시 0을 반환")
    void nullOrEmpty(String input) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"1,1","5,5","123,123"})
    @DisplayName("하나의 숫자만 입력된 경우 해당 수를 반환한다.")
    void singleNumericInput(String input, int expected) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자의 합을 반환한다")
    void defaultCommaSeparator() {
        final int result = StringSumCalculator.calculate("1,2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론으로 구분된 숫자의 합을 반환한다")
    void defaultColonSeparator() {
        final int result = StringSumCalculator.calculate("1:2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표와 콜론으로 구분된 숫자의 합을 반환한다")
    void defaultSeparator() {
        final int result = StringSumCalculator.calculate("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,:2:3 | 6",
            ",1     | 1",
            "1,     | 1"
    }, delimiter = '|')
    @DisplayName("쉼표와 콜론으로 구분할 때 그 사이 빈 문자열은 0으로 본다")
    void blankBetweenDefaultSeparator(String input, int expected) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수가 들어있는 경우 RuntimeException")
    void acceptNonNegativeNumbersOnly() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("-1,2:3");
        }).withMessage("value can not be negative.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3)", "a", " ", "1, 2"})
    @DisplayName("숫자와 구분자 외 문자가 들어있는 경우 RuntimeException")
    void acceptNumericExpressionsOnly(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate(input);
        }).withMessage("only numeric expressions are allowed.");
    }

    @Test
    @DisplayName("//와 \\n 사이의 커스텀 구분자로 구분된 숫자의 합을 반환한다")
    void customSeparator() {
        final int result = StringSumCalculator.calculate("//;\n1;2;3;4");

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정해도 쉼표와 콜론 또한 구분자로 사용한다")
    void customSeparatorWithDefaultSeparators() {
        final int result = StringSumCalculator.calculate("//;\n1,2:3;4");

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자 지정은 문자열 맨 앞에서만 인식한다")
    void customSeparatorAmongInput() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("1,//;\n2");
        }).withMessage("only numeric expressions are allowed.");
    }

    @Test
    @DisplayName("커스텀 구분자 지정 뒤 본문에 줄바꿈이 있으면 예외")
    void customSeparatorWithNewLineInput() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("//;\n1;2\n3");
        }).withMessage("only numeric expressions are allowed.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'//.\n1.2'   ; 3",
            "'//|\n1|2'   ; 3",
            "'//|\n1|2:3' ; 6"
    }, delimiter = ';')
    @DisplayName("정규식 특수문자도 커스텀 구분자로 쓸 수 있다")
    void regexCustomSeparator(String input, int expected) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자로 여러 문자가 들어있는 경우 RuntimeException")
    void customSeparatorWithMultipleCharacterInput() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("//;|\n1;2|3");
        }).withMessage("custom separator must be a single character.");
    }

    @Test
    @DisplayName("커스텀 구분자 지정이 빈 경우 RuntimeException")
    void customSeparatorWithEmptyInput() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("//\n1:2:3");
        }).withMessage("custom separator is empty.");
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자가 들어온 경우 RuntimeException")
    void customSeparatorWithNumericInput() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("//1\n213");
        }).withMessage("custom separator can not be a number.");
    }

    @Test
    @DisplayName("커스텀 구분자로 - 기호가 들어온 경우 RuntimeException")
    void customSeparatorWithMinusSign() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            StringSumCalculator.calculate("//-\n-1-3");
        }).withMessage("custom separator can not be '-'.");
    }
}
