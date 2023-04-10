package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    @DisplayName("Return 0 When input value is Null or Empty")
    void nullOrEmpty() {
        int expected = 0;
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(expected);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(expected);
    }

    @Test
    @DisplayName("Return the Number When input value is just a number")
    void oneNumber() throws NumberFormatException {
        String number = "3";
        int expected = 3;
        assertThat(StringAddCalculator.splitAndSum(number)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Return Sum of Numbers When input value is concatenated numbers by comma")
    void concatenatedByComma() {
        String input = "1,5";
        int expected = 6;
        assertThat(StringAddCalculator.splitAndSum(input))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Return Sum of Numbers When input value is concatenated numbers by comma or colon")
    void concatenatedByCommaOrColon() {
        String input = "1,3:7";
        int expected = 11;
        assertThat(StringAddCalculator.splitAndSum(input))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Return Sum of Numbers When input value is concatenated numbers by custom delimiter")
    void concatenatedByCustomDelimiter() {
        String input = "//-\n3-8";
        int expected = 11;
        assertThat(StringAddCalculator.splitAndSum(input))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Throws RuntimeException When any of input value is negative number")
    void containsNegativeNumber() {
        String input = "8,-5";
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
