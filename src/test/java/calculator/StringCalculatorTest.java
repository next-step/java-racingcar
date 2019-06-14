package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {


    @Test
    void plus() {
        String input = "2 + 3";
        Assertions.assertThat(StringCalculator.of(input).calculate()).isEqualTo(5);
    }
}
