package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Calculator.NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE;

public class CalculatorTest {

    @Test
    @DisplayName("피연산자가 Null이거나 Empty인 경우 Exception을 발생한다.")
    void assertNullOrEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.assertNullOrEmpty(" ");
        }).withMessage(NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.assertNullOrEmpty(null);
        }).withMessage(NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.assertNullOrEmpty("");
        }).withMessage(NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("입력받은 수식이 공백을 기준으로 잘 쪼개지는지 테스트한다.")
    void splitExpression() {
        String expression = "2 + 3 * 4 / 2";

        assertThat(Calculator.splitExpression(expression)).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }
}
