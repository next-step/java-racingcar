package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @DisplayName("빈 문자열 이거나 null 일 경우")
    @Test
    void nullOrEmptyShouldReturnZero() {
        assertThat(StringAddCalculatorTest.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculatorTest.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void aCharacterShouldReturnANumber() {
        assertThat(StringAddCalculatorTest.splitAndSum("2")).isEqualTo(2);
    }

    @Test
    void numbersWithCommaShouldReturnSum() {
        assertThat(StringAddCalculatorTest.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void numbersWithColonShouldReturnSum() {
        assertThat(StringAddCalculatorTest.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void customDelimiter() {
        assertThat(StringAddCalculatorTest.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void negativeNumberShouldThrowException() {
        assertThatThrownBy(() -> StringAddCalculatorTest.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
}
