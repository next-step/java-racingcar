package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    private Expression expression;
    private Calculator calculator;

    @ParameterizedTest
    @CsvSource({"20 + 10,30","20 - 10,10","20 * 10,200","20 / 10,2"})
    @DisplayName("사칙연산 test")
    void calculationTest(String inputData, Long result) {
        expression = new Expression(inputData);
        calculator = new Calculator(expression);
        Long testResult = calculator.calculate();
        assertThat(testResult).isEqualTo(result);
    }

    @Test
    @DisplayName("사칙연산기호 아닐경우 test")
    void illegalOperatorTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    expression = new Expression("20 ? 10");
                    calculator = new Calculator(expression);
                    Long result = calculator.calculate();
                }).withMessageMatching("\\S is not operator");
    }

    @Test
    @DisplayName("사칙연산 모두포함 결과 test")
    void ResultTest() {
        expression = new Expression("20 + 10 * 2 - 10 / 5");
        calculator = new Calculator(expression);
        Long result = calculator.calculate();
        assertThat(result).isEqualTo(10);
    }
}
