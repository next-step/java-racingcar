package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MathematicalExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void splitExpressionWithIllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            MathematicalExpression expression = new MathematicalExpression(value);
        }).withMessage(ExceptionMessage.EMPTY_OR_NULL_ARGUMENT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 10 3", "1 + 10 3 1", "1 + 10 + +", "2 + - 4 * 1 2", "+ 2 - 1 * 3 / 2 5", "+ 2 - 1 * 3 /"})
    @DisplayName("연산자와 피연산자의 개수, 순서가 올바르지 않은 경우")
    void calculateWithIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            MathematicalExpression expression = new MathematicalExpression(input);
        }).withMessage(ExceptionMessage.NOT_EXPECTED_ARGUMENT.getMessage());
    }

    @Test
    @DisplayName("숫자만 반환 테스트")
    void getNumbers() {
        MathematicalExpression processor = new MathematicalExpression("2 + 3 / 4 * 5");
        assertThat(processor.getNumbers())
                .containsExactly(2, 3, 4, 5);
    }

    @Test
    @DisplayName("연산자만 반환 테스트")
    void getOperators() {
        MathematicalExpression processor = new MathematicalExpression("2 + 3 / 4 * 5");
        assertThat(processor.getOperators())
                .containsExactly(Operator.PLUS, Operator.DIVIDE, Operator.MULTIPLY);
    }
}
