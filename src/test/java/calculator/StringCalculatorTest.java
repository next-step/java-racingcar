package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {


    @Test
    void plus() {
        String input = "2 + 3";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(5);
    }

    @Test
    void minut(){
        String input = "5 - 3";
        assertThat(StringCalculator.of(input).calculate()).isEqualTo(2);
    }
}
