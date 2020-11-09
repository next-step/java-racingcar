package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    static final Calculator c = new Calculator();

    @Test
    void testPlus() {
        assertThat(c.eval("1 + 2")).isEqualTo(3);
    }

    @Test
    void testMinus() {
        assertThat(c.eval("1 - 2")).isEqualTo(-1);
    }

    @Test
    void testMultiply() {
        assertThat(c.eval("1 * 2")).isEqualTo(2);
    }

    @Test
    void testDivide() {
        assertThat(c.eval("5 / 2")).isEqualTo(2);
    }

    @Test
    void testDivideByZero() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            c.eval("1 / 0");
        });
    }

    @Test
    void testBlankExpression() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.eval(null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.eval("");
        });
    }

    @Test
    void testInvalidOperand() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.eval("1 + b");
        });
    }

    @Test
    void testInvalidOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.eval("1 & 2");
        });
    }

    @Test
    void testInvalidExpression() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.eval("1 2 +");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.eval("+ 1 2");
        });
    }

    @Test
    void testComplex() {
        assertThat(c.eval("2 + 3 * 4 / 2")).isEqualTo(10);
    }

}
