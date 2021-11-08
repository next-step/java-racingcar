package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void plus() {
        int ans = calculator.calculate("2 + 3");
        assertThat(ans).isEqualTo(5);
    }

    @Test
    void minus() {
        int ans = calculator.calculate("3 - 2");
        assertEquals(1, ans);
    }

    @Test
    void multiply() {
        int ans = calculator.calculate("3 * 2");
        assertEquals(6, ans);
    }

    @Test
    void divide() {
        int ans = calculator.calculate("6 / 2");
        assertEquals(3, ans);
    }

    @Test
    void longInput() {
        int ans = calculator.calculate("3 + 3 / 2");
        assertEquals(3, ans);
    }

    @Test
    void nullInput() {
        assertThatThrownBy(() -> calculator.calculate(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyInput() {
        assertThatThrownBy(() -> calculator.calculate("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
