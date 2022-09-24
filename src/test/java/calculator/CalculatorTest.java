package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {
    @Test
    public void splitAndAddString_null_또는_빈문자() {
        assertThat(StringAddCalculator.splitAndAddString(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndAddString("")).isEqualTo(0);
    }
}
