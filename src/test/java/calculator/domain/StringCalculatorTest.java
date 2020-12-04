package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("덧셈")
    @Test
    void add() {
        StringCalculator stringCalculator = new StringCalculator();
        double result = stringCalculator.calculate("+", 1, 2);
        assertThat(result).isEqualTo(3);
    }
}
