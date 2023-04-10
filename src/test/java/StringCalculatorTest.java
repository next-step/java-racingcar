import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    public void zeroIfNull() {
        String input = null;
        var result = StringCalculator.sumOfNumbers(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void zeroIfEmpty() {
        var input = "";
        var result = StringCalculator.sumOfNumbers(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "123"})
    public void splitAndAdd(String input) {
        var result = StringCalculator.sumOfNumbers(input);
        var expected = Long.parseLong(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3",
            "2,3,4:9",
            "12,12,23:47",
    }, delimiter = ':')
    public void splitAndAdd(String input, Long expected) {
        var result = StringCalculator.sumOfNumbers(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void multipleDelimiters() {
        var input = "1,2:3";
        var result = StringCalculator.sumOfNumbers(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void customDelimiters() {
        var input = "//;\n1;2;3";
        var result = StringCalculator.sumOfNumbers(input);
        assertThat(result).isEqualTo(6);
    }

    @Test()
    public void negativeValueInput() {
        var input = "-1,2,3";
        assertThatThrownBy(() -> StringCalculator.sumOfNumbers(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Negative number was given");
    }
}
