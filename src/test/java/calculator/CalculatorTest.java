package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("문자열 사칙 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10", "40 / 8 : 5", "5 + 2 * 7 : 49",  "4 - 2 * 20 / 5 : 8"}, delimiter = ':')
    void calculator(final String str, final int result) {
        assertThat(calculator.calculate(str)).isEqualTo(result);
    }
}
