package stage2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void calculator() {
        String input = "2 + 3 * 4 / 2";
        Integer expectedValue = 10;

        Calculator c = new Calculator();
        Integer result = c.execute(input);

        assertThat(expectedValue).isEqualTo(result);
    }
}
