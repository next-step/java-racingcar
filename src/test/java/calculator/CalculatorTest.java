package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest(name = "덧셈 연산이 가능하다.")
    @CsvSource(value = {"1 + 2, 3", "4 + 5, 9", "100 + 200, 300"})
    public void additionTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "뺄셈 연산이 가능하다.")
    @CsvSource(value = {"2 - 1, 1", "4 - 5, -1", "100 - 100, 0"})
    public void subtractionTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "곱셈 연산이 가능하다.")
    @CsvSource(value = {"2 * 1, 2", "4 * -5, -20", "100 * 0, 0"})
    public void multiplicationTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "나눗셈 연산이 가능하다.")
    @CsvSource(value = {"2 / 1, 2", "4 / -2, -2", "100 / 1, 100"})
    public void divisionTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    @NullAndEmptySource
    public void invalidInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessageContaining(String.format("입력 값이 유효하지 않습니다. %s", input));
    }

    @ParameterizedTest(name = "사칙연산 기호가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"1 % 2", "2 ^ 2"})
    public void invalidOperatorTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate(input))
                .withMessageContaining("존재하지 않는 연산자입니다.");
    }

    @DisplayName("사칙연산을 모두 포함하는 연산식 계산이 가능하다.")
    @Test
    public void arithmeticOperationTest() {
        String input = "2 + 3 * 4 / 2";
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(10);
    }

}