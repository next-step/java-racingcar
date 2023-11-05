package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static calculator.StringAdditionCalculator.cal;

public class CalculatorTest {

    @Test
    void emptyValue() {
        Assertions.assertThat(cal("")).isEqualTo(0);
        Assertions.assertThat(cal(null)).isEqualTo(0);
    }

    @Test
    void oneNumber() {
        Assertions.assertThat(cal("1")).isEqualTo(1);
        Assertions.assertThat(cal("2")).isEqualTo(2);
    }

    @Test
    void containComma() {
        Assertions.assertThat(cal("1,2")).isEqualTo(3);
        Assertions.assertThat(cal("1,2,3")).isEqualTo(6);
    }

    @Test
    void containColon() {
        Assertions.assertThat(cal("1:2")).isEqualTo(3);
        Assertions.assertThat(cal("1:2:3")).isEqualTo(6);
    }

    @Test
    void containsCommaColon() {
        Assertions.assertThat(cal("1,2:3")).isEqualTo(6);
    }

    @Test
    void differentElement() {
        Assertions.assertThat(cal("//@\n1@2@3")).isEqualTo(6);
        Assertions.assertThat(cal("//!\n1!2!3")).isEqualTo(6);
    }

    @Test
    void negativeInteger() {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal("-1,2,3")).withMessage("For input string: -1");
    }

    @Test
    void differentPattern() {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal("!2,3")).withMessage("For input string: \"!2\"");
    }
}
