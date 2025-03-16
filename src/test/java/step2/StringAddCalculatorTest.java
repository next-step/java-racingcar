package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.StringAddCalculator.splitAndSum;

class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
}