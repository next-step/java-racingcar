package step2.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("input: null --> output: 0")
    public void givenNull_whenCalculate_thenReturnZero() {
        int result = StringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("input: \"\"(=Empty String) --> output: 0")
    public void givenEmptyString_whenCalculate_thenReturnZero() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("input: \" \"(=Blank) --> output: RuntimeException")
    public void givenBlank_whenCalculate_thenThrowException() {
        assertThatThrownBy(() -> StringAddCalculator.calculate(" ")).isExactlyInstanceOf(
            StringAddCalculatorInputValidatorException.class);
    }

    @Test
    @DisplayName("input: \"1\" --> output: 1")
    public void givenOneNumber_whenCalculate_thenReturnJustNumber() {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("input: \"1,2\" --> output: 3")
    public void givenTwoNumbersWithComma_whenCalculate_thenReturnSum() {
        int result = StringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("input: \"1,2:3\" --> output: 6")
    public void givenThreeNumbersWithCommaAndColon_whenCalculate_thenReturnSum() {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("input: \"//;\\n1;2;3\" --> output: 6")
    public void givenThreeNumbersWithCustomDelimiter_whenCalculate_thenReturnSum() {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("input: \"//-\n1-2-3\" --> output: 6")
    public void givenThreeNumbersWithCustomDelimiterMinus_whenCalculate_thenReturnSum() {
        int result = StringAddCalculator.calculate("//-\n1-2-3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("input: \"-1,2,3\" --> output: StringAddCalculatorTokenException(=RuntimeException)")
    public void givenNegativeNumber_whenCalculate_thenThrowException() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2,3")).isExactlyInstanceOf(
            StringAddCalculatorTokenException.class);
    }

    @Test
    @DisplayName("input: \"//-\n-1-2-3\" --> output: RuntimeException")
    public void givenNegativeNumberWithCustomDelimiterMinus_whenCalculate_thenThrowException() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("//-\n-1-2-3")).isExactlyInstanceOf(
            StringAddCalculatorTokenException.class);
    }

    @Test
    @DisplayName("input: \"11,22:33\" --> output: 66")
    public void givenTwoDigits_whenCalculate_thenReturnSum() {
        int result = StringAddCalculator.calculate("11,22:33");
        assertThat(result).isEqualTo(66);
    }
}
