package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @DisplayName("test of plus method")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 1", "10 + 23", "102 + 295 + 13"})
    void plusTest(String str) throws Exception {
        assertThat(cal.calculate(str)).isInstanceOf(Integer.class);
    }

    @DisplayName("test of minus method")
    @ParameterizedTest
    @ValueSource(strings = {"1 - 1", "15 - 4", "290 - 44 - 109"})
    void minusTest(String str) throws Exception {
        assertThat(cal.calculate(str)).isInstanceOf(Integer.class);
    }

    @DisplayName("test of multiple method")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 1", "238 * 0", "8 * 8 * 2"})
    void multipleTest(String str) throws Exception {
        assertThat(cal.calculate(str)).isInstanceOf(Integer.class);
    }

    @DisplayName("test of devide method")
    @ParameterizedTest
    @ValueSource(strings = {"1 / 1", "99 / 11", "384 / 2 / 192"})
    void devideTest(String str) throws Exception {
        assertThat(cal.calculate(str)).isInstanceOf(Integer.class);
    }

    @DisplayName("test of null, white space input case")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void IllegalArgumentException1(String str) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                cal.calculate(str);
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("test of Not four arithmetic operations case")
    @ParameterizedTest
    @ValueSource(strings = {"1 = 1", "2 ) 2"})
    void IllegalArgumentException2(String str) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                cal.calculate(str);
            }).isInstanceOf(IllegalArgumentException.class);
    }

}
