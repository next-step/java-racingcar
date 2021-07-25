package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    private final StringCalculator sut = new StringCalculator();

    @Test
    @DisplayName("덧셈")
    public void plus() {
        int result = sut.calculate("1 + 2");

        assertThat(result).isEqualTo(3);
    }
}