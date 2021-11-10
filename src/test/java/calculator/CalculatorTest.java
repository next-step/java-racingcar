package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    public void 값_null() {
        assertThatThrownBy(() ->
                Calculator.calculate(null)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @Test
    public void 값_빈공간() {
        assertThatThrownBy(() ->
                Calculator.calculate("")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "3 - 1,2", "2 * 3,6", "6 / 2,3"})
    public void calculate(String value, int expected) {
        int result = Calculator.calculate(value);
        assertThat(result).isEqualTo(expected);
    }
}
