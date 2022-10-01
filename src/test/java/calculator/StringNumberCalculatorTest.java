package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringNumberCalculatorTest {

    @Test
    void nullOrSpace() {
        assertThat(StringNumberCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum("")).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"TDD", "-1", "-5", "-100"})
    void nonNumericOrMinus(String input) {
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void zero() {
        assertThat(StringNumberCalculator.splitAndSum("0")).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:5", "10:10", "100:100"}, delimiter = ':')
    void onePositive(String input, int expected) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,1:3", "5,10:15", "10,5:15", "1,2,3:6", "3,2,1:6", "1,2,3,4:10", "4,3,2,1:10"}, delimiter = ':')
    void commaDelimiter(String input, int expected) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2,3", "2:1,3", "5:10,15", "10:5,15", "1:2:3,6", "3:2:1,6", "1:2:3:4,10", "4:3:2:1,10"}, delimiter = ',')
    void colonDelimiter(String input, int expected) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @Test
    void customDelimiter() {
        assertThat(StringNumberCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
        assertThat(StringNumberCalculator.splitAndSum("//;\n2;1")).isEqualTo(3);
    }


}
