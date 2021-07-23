package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(Operation.PLUS.calculate(2, 3)).isEqualTo(5);
        assertThat(Operation.PLUS.calculate(-1, 3)).isEqualTo(2);
    }

    @Test
    void 뺄셈() {
        assertThat(Operation.MINUS.calculate(1, 2)).isEqualTo(-1);
        assertThat(Operation.MINUS.calculate(5, 2)).isEqualTo(3);
    }

    @Test
    void 곱셈() {
        assertThat(Operation.MULTIPLY.calculate(1, 2)).isEqualTo(2);
        assertThat(Operation.MULTIPLY.calculate(4, 6)).isEqualTo(24);
    }

    @Test
    void 나눗셈() {
        assertThat(Operation.DIVIDE.calculate(2, 3)).isEqualTo(0);
        assertThat(Operation.DIVIDE.calculate(20, 4)).isEqualTo(5);
        assertThat(Operation.DIVIDE.calculate(4, 3)).isEqualTo(1);
    }

    @DisplayName("0으로 나눌 때 IllegalArgumentException throw")
    @Test
    void 나눗셈_0으로_나눌때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operation.DIVIDE.calculate(1, 0));
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @Test
    void 입력값() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.checkInput(null));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.checkInput(""));
    }

    @Test
    void 연산_success() {
        assertThat(Operation.findOperation("+")).isEqualTo(Operation.PLUS);
        assertThat(Operation.findOperation("-")).isEqualTo(Operation.MINUS);
        assertThat(Operation.findOperation("*")).isEqualTo(Operation.MULTIPLY);
        assertThat(Operation.findOperation("/")).isEqualTo(Operation.DIVIDE);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void 연산_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operation.findOperation("."));
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "4 + 1 * 3 / 1:15"}, delimiter = ':')
    void 사칙연산(String input, long expect) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expect);
    }
}