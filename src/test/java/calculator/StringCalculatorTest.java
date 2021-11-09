package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("2단계 - 문자열 계산기")
public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈")
    void add() {
        String expression = "1 + 2 + 7";
        assertThat(StringCalculator.calculate(expression))
                .isEqualTo(10L);
    }

    @Test
    @DisplayName("뺄셈")
    void subtract() {
        String expression = "6 - 7 - -2";
        assertThat(StringCalculator.calculate(expression))
                .isEqualTo(1L);
    }

    @Test
    @DisplayName("곱하기")
    void multiply() {
        String expression = "2 * 6 * 2";
        assertThat(StringCalculator.calculate(expression))
                .isEqualTo(24L);
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        String expression = "12 / 2 / 3";
        assertThat(StringCalculator.calculate(expression))
                .isEqualTo(2L);
    }

    @Test
    @DisplayName("나누기 - 0으로 나누기 - IllegalArgumentException 발생")
    void dividedByZero() {
        String expression = "6 / 0";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(expression));
    }

    @Test
    @DisplayName("여러 사칙 연산")
    void calculateLongString() {
        String expression = "7 + 1 - -10 * 2 / 3";
        assertThat(StringCalculator.calculate(expression))
                .isEqualTo(12L);
    }

    @Test
    @DisplayName("null 입력 예외")
    void nullExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(null));
    }

    @Test
    @DisplayName("공백 입력 예외")
    void emptyExpression() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(""));
    }
}
