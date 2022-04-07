package calculator;

import static calculator.StringAddCalculator.NEGATIVE_VALIDATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void nullOrEmptyStringGiven_ReturnZero() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void singleStringGiven_ShouldParseInt() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void stringWithColonOrCommaGiven_ReturnSum() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void customDelimiterGiven_ReturnSum() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("//:\n1:2:3")).isEqualTo(6);
    }

    @Test
    void noneNumberGiven_ShouldThrowRuntimeException() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("abcd"))
            .isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1bcd"))
            .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void negativeGiven_ShouldThrowRuntimeException() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NEGATIVE_VALIDATION);
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-12321"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NEGATIVE_VALIDATION);
    }
}
