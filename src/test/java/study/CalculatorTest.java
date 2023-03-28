package study;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @DisplayName("문자열 계산기 정상 작동을 확인해보자")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 | 10.0"}, delimiter = '|')
    void caculator(final String string, final float result) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(string));
        assertThat(calculator.calculate(string)).isEqualTo(result);
    }
}
