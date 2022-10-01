package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringNumberCalculatorTest {

    @Test
    void nullOrSpace() {
        assertThat(StringNumberCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void nonNumericOrMinusNumber() {
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum("TDD")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum("-1")).isInstanceOf(RuntimeException.class);
    }

}
