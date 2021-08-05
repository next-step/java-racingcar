package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 = 3", "2 + 4 = 6"}, delimiter = '=')
    public void plusTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 - 1 = 1", "4 - 2 = 2"}, delimiter = '=')
    public void minusTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 * 3 = 6", "4 * 2 = 8"}, delimiter = '=')
    public void multiplicationTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6 / 3 = 2", "8 / 2 = 4"}, delimiter = '=')
    public void divisionTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @DisplayName("Empty 데이터에서 에러 테스트")
    @Test
    public void emptyDataTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(""));
    }

    @DisplayName("null 데이터에서 에러 테스트")
    @Test
    public void nullDataTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(null));
    }

    @DisplayName("전체 사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6 + 3 - 3 * 2 / 2 = 6", "1 + 2 + 3 * 2 = 12", "2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    public void arithmeticOperationTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @DisplayName("사칙연산 기호가 아닐 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"6 & 3"})
    public void nonOperatorTest(String data) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(data));
    }
}
