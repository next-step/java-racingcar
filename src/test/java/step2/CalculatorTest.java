package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void 덧셈() {
        assertThat(Calculator.calculate("3 + 4")).isEqualTo(7);
    }

    @Test
    void 뺼셈() {
        assertThat(Calculator.calculate("8 - 4")).isEqualTo(4);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.calculate("3 * 4")).isEqualTo(12);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.calculate("20 / 5")).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "  * 2 + 3"})
    void 입력값이_Null_또는_빈공백(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                Calculator.calculate(input);
        });
    }
}