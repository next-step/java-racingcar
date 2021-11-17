package calculator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void add() {
        int result = Calculator.compute("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = Calculator.compute("3 - 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        int result = Calculator.compute("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = Calculator.compute("6 / 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void severalOperators() {
        int result = Calculator.compute("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Nested
    class ExceptionTest {
        @Test
        void nullInput() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Calculator.compute(null);
            });
        }

        @Test
        void blankInput() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Calculator.compute("");
            });
        }

        @Test
        void illegalOperator() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Calculator.compute("2 > 1");
            });
        }
    }
}
