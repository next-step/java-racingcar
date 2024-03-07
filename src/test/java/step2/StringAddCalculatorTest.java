package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void blankTest() {
        int number = StringAddCalculator.cal("");
        assertThat(number).isEqualTo(0);
    }

    @Test
    void nullTest() {
        int number = StringAddCalculator.cal(null);
        assertThat(number).isEqualTo(0);
    }


}
