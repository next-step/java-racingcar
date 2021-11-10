package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    public void 덧셈() {
        int result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = Calculator.calculate("5 - 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 곱셈() {
        int result = Calculator.calculate("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗셈() {
        int result = Calculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);

        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("값이 null인지 빈공간인지 테스트")
    public void 값_null_빈공간(String input) {
        assertThatThrownBy(() ->
                Calculator.calculate(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "3 - 1,2", "2 * 3,6", "6 / 2,3"})
    @DisplayName("calculate() 전체 연산 테스트")
    public void calculate(String value, int expected) {
        int result = Calculator.calculate(value);
        assertThat(result).isEqualTo(expected);
    }
}
