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

    @Test
    void singleValue() {
        assertThat(cal("1")).isEqualTo(1);
    }

    @Test
    void multiValue_comma() {
        assertThat(cal("1,2")).isEqualTo(3);
        assertThat(cal("1,2,3")).isEqualTo(6);
    }

    @Test
    void multiValue_colon() {
        assertThat(cal("1:2")).isEqualTo(3);
        assertThat(cal("1:2:3")).isEqualTo(6);
    }
}