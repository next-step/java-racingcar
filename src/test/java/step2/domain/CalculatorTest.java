package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.domain.Calculator.NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    @DisplayName("피연산자가 Null이거나 Empty인 경우 Exception을 발생한다.")
    void assertNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.assertNullOrEmpty(input);
        }).withMessage(NULL_OR_EMPTY_STRING_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("입력받은 수식이 공백을 기준으로 잘 쪼개지는지 테스트한다.")
    void splitExpression() {
        String expression = "2 + 3 * 4 / 2";

        assertThat(Calculator.splitExpression(expression)).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @DisplayName("최종 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 * 9:90", "1 + 3 * 2 / 4 / 1:2"}, delimiter = ':')
    void calculate(String input, Integer expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }
}
