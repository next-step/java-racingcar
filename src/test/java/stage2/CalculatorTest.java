package stage2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorTest {

    @Test
    void calculator() {
        String input = "2 + 3 * 4 / 2";
        Integer expectedValue = 10;

        Calculator c = new Calculator();
        Integer result = c.execute(input);

        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    @DisplayName("Null exception 테스트")
    void calculator_null_test() {
        String input = null;

        Calculator c = new Calculator();
        Throwable throwable = catchThrowable(() -> c.execute(input));

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
