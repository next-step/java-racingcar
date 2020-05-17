package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringExpressionTest {
    @DisplayName("입력 값이 null 일 경우 IllegalArgumentException 을 뱉어냄")
    @ParameterizedTest
    @NullSource
    void isNullShouldThrowIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringExpression(input);
        }).withMessage(StringExpression.INPUT_NULL_EXCEPTION_MESSAGE);
    }

    @DisplayName("입력 값이 공백 혹은 whitespace 일 경우 IllegalArgumentException 을 뱉어냄")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void isEmptyShouldThrowIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringExpression(input);
        }).withMessage(StringExpression.INPUT_EMPTY_OR_WHITESPACE_ONLY_EXCEPTION_MESSAGE + "'" + input + "'");
    }

    @DisplayName("계산기 테스트")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10"})
    void stringExpression(String input, int result) {
        StringExpression expression = new StringExpression(input);
        assertThat(expression.getResult()).isEqualTo(result);
    }
}
