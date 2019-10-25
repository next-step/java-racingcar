package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
         stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2"}, delimiter = ',')
    void plus(int operand1, int operand2) {
        int result = stringCalculator.plus(operand1, operand2);
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2"}, delimiter = ',')
    void minus(int operand1, int operand2) {
        int result = stringCalculator.minus(operand1, operand2);
        assertThat(result).isEqualTo(-1);
    }
}
