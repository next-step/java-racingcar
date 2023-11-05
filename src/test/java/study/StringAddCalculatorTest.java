package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {
    @Test
    void blankOrNullTo0() {
        assertThat(StringAddCalculator.sum("")).isZero();
        assertThat(StringAddCalculator.sum(null)).isZero();
    }
}
