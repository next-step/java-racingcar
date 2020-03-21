package stringcalculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @DisplayName("사용자 입력 받기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void init(String source) {
        Expression expression = new Expression(source);

        assertThat(expression).isNotNull();
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
        assertThatThrownBy(() -> new Expression(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
    }

    @DisplayName("입력값 중 연산자가 사칙연산 기호가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1 A 3", "1 = !", "3 & 1"})
    void isNotPermittedOperatorTest(String source) {
        assertThatThrownBy(() -> new Expression(source))
                .hasMessageContaining("연산자는 사칙연산 기호만 사용할 수 있습니다.");
    }

    @DisplayName("입력값은 반드시 숫자로 시작해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"A 1", "* 2", "$"})
    void expressionMustStartIntegerTest(String source) {
        assertThatThrownBy(() -> new Expression(source));
    }

    @DisplayName("사이즈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void sizeTest(String source) {
        Expression expression = new Expression(source);
        assertThat(expression.getOperators()).hasSize(3);
        assertThat(expression.getNumbers()).hasSize(4);
    }

}
