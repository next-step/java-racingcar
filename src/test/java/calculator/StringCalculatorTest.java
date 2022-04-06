package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void splitAndSum_NullAndEmptyStringGiven_ReturnZero() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void splitAndSum_StringWithColonOrCommaGiven_ReturnSum() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

}
