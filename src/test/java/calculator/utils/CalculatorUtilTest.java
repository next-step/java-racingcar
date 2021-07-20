package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorUtilTest {

    private CalculatorUtil calculatorUtil = new CalculatorUtil();

    @ParameterizedTest
    @DisplayName("사칙연산 값 확인")
    @CsvSource(value = {"+,3,6,9", "-,10,1,9", "*,14,2,28", "/,14,7,2"}, delimiter = ',')
    void calculate(String operator, int operand1, int operand2, int expected) {
        int result = calculatorUtil.calculate(operator, operand1, operand2);

        assertThat(result).isEqualTo(expected);
    }
}
