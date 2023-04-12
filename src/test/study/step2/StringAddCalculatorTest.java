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
}
