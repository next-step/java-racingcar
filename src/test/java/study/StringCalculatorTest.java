package study;

import calcurator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {


    @Test
    void testStringCalculatorAddSign() {
        assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3);

    }


}
