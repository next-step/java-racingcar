package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @DisplayName("test of plus method")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1,2", "10 + 23,33", "100 + 295 + 13,408"}, delimiter = ',')
    void plusTest(String str, int result) throws Exception {
        Calculator cal = new Calculator();
        assertThat(cal.calculate(str)).isEqualTo(result);
    }

    @DisplayName("test of minus method")
    @ParameterizedTest
    @CsvSource(value = {"1 - 1,0", "15 - 4,11", "290 - 44 - 109,137"}, delimiter = ',')
    void minusTest(String str, int result) throws Exception {
        Calculator cal = new Calculator();
        assertThat(cal.calculate(str)).isEqualTo(result);
    }

    @DisplayName("test of multiple method")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 1", "238 * 0", "8 * 8 * 2"})
    void multipleTest(String str) throws Exception {
        Calculator cal = new Calculator();
        assertThat(cal.calculate(str)).isInstanceOf(Integer.class);
    }

    @DisplayName("test of devide method")
    @ParameterizedTest
    @ValueSource(strings = {"1 / 1", "99 / 11", "384 / 2 / 192"})
    void devideTest(String str) throws Exception {
        Calculator cal = new Calculator();
        assertThat(cal.calculate(str)).isInstanceOf(Integer.class);
    }

    @DisplayName("test of null, white space input case")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void IllegalArgumentException1(String str) {
        Calculator cal = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                cal.calculate(str);
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("test of Not four arithmetic operations case")
    @ParameterizedTest
    @ValueSource(strings = {"1 = 1", "2 ) 2"})
    void IllegalArgumentException2(String str) {
        Calculator cal = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                cal.calculate(str);
            }).isInstanceOf(IllegalArgumentException.class);
    }
}
