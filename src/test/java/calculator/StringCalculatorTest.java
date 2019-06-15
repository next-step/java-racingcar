package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {


    @Test
    void addition() {
        String input = "2 + 3";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(5);
    }

    @Test
    void subtraction() {
        String input = "5 - 3";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(2);
    }

    @Test
    void multiplication() {
        String input = "5 * 3";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(15);
    }

    @Test
    void division() {
        String input = "6 / 2";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(3);
    }

    @Test
    void throwIllegalArgumentExceptionWhenInputNull() {
        String input = null;
        assertThatThrownBy(() -> StringCalculator.of(input).calculate()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwIllegalArgumentExceptionWhenInputIsNotSignForMath() {
        String input = "5 ] 3";
        assertThatThrownBy(() -> StringCalculator.of(input).calculate()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate() {
        String input = "2 + 3 * 4 / 2";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(10);
    }
}
