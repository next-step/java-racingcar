package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Calculator 사칙 연산")
class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=3", "-1=0", "-3=-2"}, delimiter = '=')
    void 덧셈(int input, int result) {
        assertThat(Calculator.add(1, input)).isEqualTo(result);
    }
}