package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringNumberCalculatorTest {

    @Test
    void nullOrSpace() {
        assertThat(StringNumberCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void nonNumericOrMinus() {
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum("TDD")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum("-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void zero() {
        assertThat(StringNumberCalculator.splitAndSum("0")).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:5", "10:10", "100:100"}, delimiter = ':')
    void onePositive(String input, int expected) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
    }

}
