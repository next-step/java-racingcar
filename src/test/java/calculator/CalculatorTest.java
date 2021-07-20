package calculator;

import calculator.calculator.Calculator;
import calculator.calculator.StringExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("문자열의 사칙연산 결과를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 * 3 - 4 / 2:1", "10 / 2 * 4 / 2:10"}, delimiter = ':')
    void calculate(String str, int expected) {
        Calculator calculator = new Calculator(new StringExpression(str));

        assertThat(calculator.calculate()).isEqualTo(expected);
    }
}