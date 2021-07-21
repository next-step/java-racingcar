package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 3 * 4 / 2 - 5:5"}, delimiter = ':')
    @DisplayName("올바르게 값이 출력되는지 확인")
    void input_valid(final String input, final int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값 공백이나 널인 경우")
    void input_blank(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator();
            int result = calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 = 4 / 2:10", "2 + 3 - 4 ! 2:10"}, delimiter = ':')
    @DisplayName("중간에 사칙연산이 올바르지 않은 경우")
    void input_operator_invalid(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator();
            int result = calculator.calculate(input);
        });
    }
}
