package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Calculator.Calculator.cal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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

    @Test
    void multiValue_custom() {
        assertThat(cal("//;\n1;2;3")).isEqualTo(6);
        assertThat(cal("//@\n1@2@3")).isEqualTo(6);
    }

    @Test
    @DisplayName("NumberFormat Exception Test")
    void parsing() {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal("!,2,3")).withMessageMatching("For input string: .*");
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal("-1,2,3")).withMessageMatching("For input string: .*");
    }
}