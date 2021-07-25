package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    private final StringCalculator sut = new StringCalculator();

    @Test
    @DisplayName("덧셈")
    public void plus() {
        int result = sut.calculateAll("1 + 2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        int result = sut.calculateAll("3 - 1");

        assertThat(result).isEqualTo(2);
    }
}