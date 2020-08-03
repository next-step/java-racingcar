package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionSeparatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 4 + 6 / 3 - 2:5", "0 + 0 - 0 * 0:4"}, delimiter = ':')
    void getInputNumbers(String expression, int result) {
        ExpressionSeparator expressionSeparator = new ExpressionSeparator(expression);
        assertThat(expressionSeparator.getInputNumbers().size()).isEqualTo(result);

    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 4 + 6 / 3 - 2:4", "0 + 0 - 0 * 0:3"}, delimiter = ':')
    void getInputOperators(String expression, int result) {
        ExpressionSeparator expressionSeparator = new ExpressionSeparator(expression);
        assertThat(expressionSeparator.getInputOperators().size()).isEqualTo(result);

    }

}