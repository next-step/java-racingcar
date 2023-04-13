package study.step2;

import main.study.step2.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("Tests that return 0 if the string is null or empty")
    void emptyStringOrNull() {
        assertThat(StringAddCalculator.splitAndSum(null)).isZero();
        assertThat(StringAddCalculator.splitAndSum("")).isZero();
    }

    @Test
    @DisplayName("Test for a single number in a string")
    void stringSingleNumber() {
        assertThat(StringAddCalculator.splitAndSum("1")).isOne();
    }

    @Test
    @DisplayName("Test with a delimiter comma")
    void sumStringNumbersWithComma() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("Test with delimiter comma and colon")
    void sumStringNumbersWithCommaAndColon() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("Test with a custom delimiter")
    void sumStringNumbersWithCustomDelimiter() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3;")).isEqualTo(6);
    }

    @Test
    @DisplayName("Test for exception on negative input")
    void runtimeExceptionWithNegativeNumber() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2,3");
        }).isExactlyInstanceOf(RuntimeException.class).hasMessageContaining("It is not positive number");
    }
}
