package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static step2.StringCalculator.calculate;

public class StringCalculatorTest {
    @DisplayName("basic operation test")
    @CsvSource(delimiter = '=', value = {
            "1 = 1",
            "1 + 5 = 6",
            "1 - 5 = -4",
            "5 * 1 = 5",
            "5 / 1 = 5",
    })
    @ParameterizedTest
    void basic(String expression, int result) {
        assertThat(calculate(expression)).isEqualTo(result);
    }

    @DisplayName("complex operation test")
    @CsvSource(delimiter = '=', value = {
            "1 + 5 - 3 * 10 / 2 = 15",
            "5 / 2 * 3 - 10 + 2 = -2",
            "5 / 2 * -3 - 10 + 2 = -14",
    })
    @ParameterizedTest
    void complex(String expression, int result) {
        assertThat(calculate(expression)).isEqualTo(result);
    }

    @DisplayName("test for illegal expressions")
    @NullAndEmptySource
    @ValueSource(strings = "    ")
    @ParameterizedTest
    void illegalExpression(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculate(expression)
        ).withMessage("expression omitted");
    }

    @DisplayName("test for incomplete expression")
    @ValueSource(strings = {
            "1 + ",     // no rhs value
    })
    @ParameterizedTest
    void incompleteExpression(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculate(expression)
        ).withMessage("incomplete expression");
    }

    @DisplayName("test for illegal operators")
    @ValueSource(strings = {
            "1 2",
            "1 + 3 x 5",
    })
    @ParameterizedTest
    void illegalOperator(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculate(expression)
        ).withMessageMatching("unknown operator symbol: .*");
    }

    @DisplayName("test for illegal values")
    @ValueSource(strings = {
            "1 - x / y",
            "1 * 5 / y",
    })
    @ParameterizedTest
    void illegalValues(String expression) {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() ->
                calculate(expression)
        ).withMessageMatching("For input string: .*");
    }
}
