package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static java.lang.Integer.parseInt;
import static step2.StringCalculator.calculate;

public class StringCalculatorTest {
    @DisplayName("basic operation test")
    @CsvSource({
            "1 + 5,6",
            "1 - 5,-4",
            "5 * 1,5",
            "5 / 1,5",
    })
    @ParameterizedTest
    void basic(String expression, String result) {
        assertThat(calculate(expression)).isEqualTo(parseInt(result));
    }

    @DisplayName("complex operation test")
    @CsvSource({
            "1 + 5 - 3 * 10 / 2,15",
            "5 / 2 * 3 - 10 + 2,-2",
            "5 / 2 * -3 - 10 + 2,-14",
    })
    @ParameterizedTest
    void complex(String expression, String result) {
        assertThat(calculate(expression)).isEqualTo(parseInt(result));
    }

    @DisplayName("test for illegal expressions")
    @NullAndEmptySource
    @ValueSource(strings = "    ")
    @ParameterizedTest
    void illegalExpression(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculate(expression)
        );
    }

    @DisplayName("test for illegal elements")
    @ValueSource(strings = {
            "1 + ",     // no rhs value
            "1 2",      // invalid operator
            "1 + 3 x 5",    // invalid operator
            "1 - x / y"     // invalid value
    })
    @ParameterizedTest
    void illegalElement(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculate(expression)
        );
    }
}
