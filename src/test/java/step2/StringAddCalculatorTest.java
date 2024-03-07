package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void oneNumberTest() {
        int number = StringAddCalculator.cal("1");
        assertThat(number).isEqualTo(1);
    }

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
