package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionProcessorTest {

    @Test
    @DisplayName("공백을 기준으로 수식 분리 테스트")
    void splitExpression() {
        assertThat(ExpressionProcessor.splitExpression("2 + 3 / 4 * 5"))
                .containsExactly("2", "+", "3", "/", "4", "*", "5");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void splitExpressionWithIllegalArumentException(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] arguments = ExpressionProcessor.splitExpression(expression);
        });
    }

    @Test
    @DisplayName("사칙연산 기호 테스트")
    void isOperator() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("사친연산 기호가 아닌 경우")
    void isNotOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator operator = Operator.of("!");
        });
    }
}
