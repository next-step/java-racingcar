package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 더하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3 + 2");
        assertThat(result).isEqualTo(5);
    }
}
