package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void name1() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({"3 + 2, 5", "3 - 2, 1", "3 * 2 + 4 / 2 - 3, 2", "3 / 2 + 4 - 2 * 3, 9"})
    void name(String sentence, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(sentence);
        assertThat(result).isEqualTo(expected);
    }
}
