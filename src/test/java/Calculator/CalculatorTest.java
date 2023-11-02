package Calculator;

import org.junit.jupiter.api.Test;

import static Calculator.Calculator.cal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {
    @Test
    void emptyValue() {
        assertThat(cal("")).isEqualTo(0);
        assertThat(cal(null)).isEqualTo(0);
    }
}