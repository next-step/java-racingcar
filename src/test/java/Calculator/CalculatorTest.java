package Calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.zip.DataFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = "3 + 2:5", delimiter = ':')
    @DisplayName("덧셈 테스트")
    void add(String input, Integer expected) throws DataFormatException {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = "3 - 2:1", delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtract(String input, Integer expected) throws DataFormatException {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }
    
    @ParameterizedTest
    @CsvSource(value = "3 * 2:6", delimiter = ':')
    @DisplayName("곱셈 테스트")
    void multiply(String input, Integer expected) throws DataFormatException {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = "4 / 2:2", delimiter = ':')
    @DisplayName("나눗셈 테스트")
    void divide(String input, Integer expected) throws DataFormatException {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }
}
