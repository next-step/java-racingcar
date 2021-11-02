package Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @ParameterizedTest
    @CsvSource(value = "2 + 3 * 4 / 2:10", delimiter = ':')
    @DisplayName("다중 연산 테스트")
    void calculate(String input, Integer expected) throws DataFormatException {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 a 2")
    @DisplayName("연산자가 아닌 다른 값이 들어왔을 경우 DataFormatException 테스트")
    void dataFormatException(String input) throws DataFormatException {
        assertThatExceptionOfType(DataFormatException.class)
            .isThrownBy(() -> {
                calculator.calculate(input);
            })
            .withMessage("올바르지 않은 연산자 입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 * a")
    @DisplayName("연산자가 아닌 다른 값이 들어왔을 경우 NumberFormatException 테스트")
    void numberFormatException(String input) throws DataFormatException {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> {
                calculator.calculate(input);
            })
            .withMessage("For input string: %s", "\"a\"");
    }
}
