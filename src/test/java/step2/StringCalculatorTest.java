package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "7 + 4:11", "4 + 8 :12", "-4 + -4:-8",
            "-4 + 12:8", "2 + 4 + 10:16", "0 + -1:-1"
    }, delimiter = ':')
    public void addTest(String param, String expected) {
        assertThat(calculator.perform(param)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "14 - 4:10", "14 - 7 :7", "4 - 20:-16",
            "7 - 7 - 7:-7", "-1 - -3:2"
    }, delimiter = ':')
    public void subtractTest(String param, String expected) {
        assertThat(calculator.perform(param)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 * 1:1", "3 * 21:63", "3 * 4 * 3:36",
            "0 * 123:0", "1004 * 0:0", "2 * -8:-16",
            "-1 * 2:-2", "-4 * -2:8"
    }, delimiter = ':')
    public void multiplyTest(String param, String expected) {
        assertThat(calculator.perform(param)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"6 / 2:3", "9 / 3 :3", "7 / 2 / 3:1",
            "7 / -1:-7", "-8 / 8:-1", "-64 / -8:8", "-8 / -64:0"
    }, delimiter = ':')
    public void divideTest(String param, String expected) {
        assertThat(calculator.perform(param)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"0 / 1", "0 / -13", "0 / 101", "0 / 10214487"}, delimiter = ':')
    public void divideZeroTest(String param) {
        assertThat(calculator.perform(param)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0 / 0", "12 * 2 / 0", "13 - 26 / 0"}, delimiter = ':')
    public void divideByZeroTest(String param) {
        assertThatThrownBy(() -> calculator.perform(param)).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10",
            "2 + 3 * 4 / 2 - -5:15",
            "17 - -17 * 20 / 5 + 6:142"
    }, delimiter = ':')
    public void fourArithmeticOperationTest(String param, String expected) {
        assertThat(calculator.perform(param)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    public void inputNullOrEmptyStringTest() {
        assertThatThrownBy(() -> calculator.perform(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.ERROR_MESSAGE);

        assertThatThrownBy(() -> calculator.perform("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "2 + 3 *", "7 / 2 + ", "2+3+1+2"})
    public void inputInsufficientStringTest(String param) {
        assertThatThrownBy(() -> calculator.perform(param)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 % 10", "1 @ 3", "1 + 2 = 3", "12 == 1"})
    public void inputUnsupportedOperatorTest(String param) {
        assertThatThrownBy(() -> calculator.perform(param)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.UNSUPPORTED_OPERATOR_ERROR_MESSAGE);
    }

}
