package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class TextCalculatorTest {

    TextCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TextCalculator();
    }

    @Test
    void plus() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }

    @Test
    void minus() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }

    @Test
    void multiplication() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }

    @Test
    void division() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }
}