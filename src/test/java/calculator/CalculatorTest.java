package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    private Expression expression;
    private Calculator calculator;

    @Test
    @DisplayName("덧셈 test")
    void additionTest() {
        expression = new Expression("20 + 10");
        calculator = new Calculator(expression);
        String result = calculator.calculate();
        assertThat(result).isEqualTo("30");
    }

    @Test
    @DisplayName("뺄셈 test")
    void subtractionTest() {
        expression = new Expression("20 - 10");
        calculator = new Calculator(expression);
        String result = calculator.calculate();
        assertThat(result).isEqualTo("10");
    }

    @Test
    @DisplayName("곱셈 test")
    void multiplicationTest() {
        expression = new Expression("20 * 10");
        calculator = new Calculator(expression);
        String result = calculator.calculate();
        assertThat(result).isEqualTo("200");
    }

    @Test
    @DisplayName("나눗셈 test")
    void divisionTest() {
        expression = new Expression("20 / 10");
        calculator = new Calculator(expression);
        String result = calculator.calculate();
        assertThat(result).isEqualTo("2");
    }

    @Test
    @DisplayName("사칙연산기호 아닐경우 test")
    void illegalOperatorTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    expression = new Expression("20 ? 10");
                    calculator = new Calculator(expression);
                    String result = calculator.calculate();
                }).withMessageMatching("\\S is not operator");
    }

    @Test
    @DisplayName("사칙연산 모두포함 결과 test")
    void ResultTest() {
        expression = new Expression("20 + 10 * 2 - 10 / 5");
        calculator = new Calculator(expression);
        String result = calculator.calculate();
        assertThat(result).isEqualTo("10");
    }
}
