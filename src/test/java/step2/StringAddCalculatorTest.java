package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    private Integer getInt(String value) throws NumberFormatException {
        return Integer.parseInt(value);
    }

    @Test
    @DisplayName("Return 0 When input value is Null or Empty")
    void nullOrEmpty() {
        Integer expected = 0;
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(expected);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(expected);
    }

    @Test
    @DisplayName("Return the Number When input value is just a number")
    void oneNumber() throws NumberFormatException {
        String number = "3";
        assertThat(StringAddCalculator.splitAndSum(number)).isEqualTo(getInt(number));
    }

    @Test
    @DisplayName("Return Sum of Numbers When input value is concatenated numbers by comma")
    void concatenatedByComma() {
        String num1 = "1";
        String num2 = "5";
        String delimiter = ",";
        assertThat(StringAddCalculator.splitAndSum(num1 + delimiter + num2))
                .isEqualTo(getInt(num1) + getInt(num2));
    }

    @Test
    @DisplayName("Return Sum of Numbers When input value is concatenated numbers by comma or colon")
    void concatenatedByCommaOrColon() {
        String num1 = "1";
        String num2 = "3";
        String num3 = "7";
        String delimiter1 = ",";
        String delimiter2 = ":";
        assertThat(StringAddCalculator.splitAndSum(num1 + delimiter1 + num2 + delimiter2 + num3))
                .isEqualTo(getInt(num1) + getInt(num2) + getInt(num3));
    }

    @Test
    @DisplayName("Return Sum of Numbers When input value is concatenated numbers by custom delimiter")
    void concatenatedByCustomDelimiter() {
        String num1 = "3";
        String num2 = "8";
        String customDelimiter = "-";
        String customDelimiterFormat = "//%s\n";
        assertThat(StringAddCalculator.splitAndSum(String.format(customDelimiterFormat, customDelimiter) + num1 + customDelimiter + num2))
                .isEqualTo(getInt(num1) + getInt(num2));
    }

    @Test
    @DisplayName("Throws RuntimeException When any of input value is negative number")
    void containsNegativeNumber() {
        String num1 = "8";
        String num2 = "-5";
        String delimiter = ",";
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(num1 + delimiter + num2))
                .isInstanceOf(RuntimeException.class);
    }
}
