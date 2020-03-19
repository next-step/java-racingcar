package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @DisplayName("사용자 입력 받기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void init(String source) {
        Expression expression = new Expression(source);

        assertThat(expression.getExpression()).isEqualTo(source.split(" "));
    }

    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void nullOrEmptyStringThrowIllegalArgumentException(String source) {
        assertThatThrownBy(() -> new Expression(source))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
    }

    @DisplayName("입력값이 null일 경우 IllegalArgumentException throw")
    @Test
    void nullExpressionThrowIllegalArgumentException() {
        String source = null;

        assertThatThrownBy(() -> new Expression(source))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
    }

    @DisplayName("사용자가 입력한 문자열 중 숫자만 분리")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3:2", "1 + 3 + 5:3", "1 + 3 + 5 - 7:4"}, delimiter = ':')
    void distributeExpression(String source, int expectedSize) {
        Expression expression = new Expression(source);
        Numbers numbers = new Numbers(expression);

        assertThat(numbers.getNumbers())
                .hasSize(expectedSize);

    }
}
