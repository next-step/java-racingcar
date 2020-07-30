package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = { "3 + 5:8", "3 - 5:-2", "3 * 5:15", "3 / 5:0", "3 + 5 - 90 / 4 * 7:-140"}, delimiter = ':')
    public void calculate(String expression, int exceptedResult) {
        assertThat(calculator.calculate(expression)).isEqualTo(exceptedResult);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "3+5", "3 $ 2", "- 3 + 6", "3.5 / 10", "10 / 2 * 5*2", "5 + 10 + 2 / 2 /", "5 / 0" })
    public void calculate_ShouldThrow_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}
