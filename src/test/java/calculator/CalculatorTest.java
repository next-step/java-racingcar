package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.cal;
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

    @DisplayName("NumberFormat Exception Test")
    @ParameterizedTest
    @ValueSource(strings = { "!2,3", "-1,2,3" })
    void parsing(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal(input)).withMessageMatching("For input string: .*");
    }
}