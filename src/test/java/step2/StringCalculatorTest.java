package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈")
    void plus() {
        assertThat(Calculator.calculate("1 + 2")).isEqualTo(new CalculatorNumber(3));
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        assertThat(Calculator.calculate("2 - 1")).isEqualTo(new CalculatorNumber(1));
    }

    @Test
    @DisplayName("곱셈")
    void times() {
        assertThat(Calculator.calculate("3 * 4")).isEqualTo(new CalculatorNumber(12));
    }

    @Test
    @DisplayName("나눗셈")
    void divideBy() {
        assertThat(Calculator.calculate("4 / 2")).isEqualTo(new CalculatorNumber(2));
    }

    @ParameterizedTest(name = "빈 문자열 혹은 null:{index}")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void nullOrBlankInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate(input))
                .withMessage("빈 문자열 혹은 null은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우")
    void illegalOperationChar() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calculate("4 = 1"))
                .withMessage("사칙연산 기호가 아닙니다.");
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능")
    void multipleOperation() {
        assertThat(Calculator.calculate("1 + 2 * 4 / 3")).isEqualTo(4);
    }
}
