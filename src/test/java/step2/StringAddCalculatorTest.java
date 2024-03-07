package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.StringAddCalculator.calculate;

public class StringAddCalculatorTest {

    @Test
    void colonAndCommaTest() {
        int number = calculate("1:2,3");
        assertThat(number).isEqualTo(6);
    }

    @Test
    void colonTest() {
        int number = calculate("1:2");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void commaTest() {
        int number = calculate("1,2");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void commaEndTest() {
        int number = calculate("1,");
        assertThat(number).isEqualTo(1);
    }

    @Test
    void oneNumberTest() {
        int number = calculate("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    void blankTest() {
        int number = calculate("");
        assertThat(number).isEqualTo(0);
    }

    @Test
    void nullTest() {
        int number = calculate(null);
        assertThat(number).isEqualTo(0);
    }


}
