package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"4 + 2:6", "4532 + 2123:6655"}, delimiter = ':')
    void add(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(new Num(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4 - 2:2", "4532 - 2123:2409"}, delimiter = ':')
    void minus(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(new Num(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4 * 2:8", "4532 * 2123:9621436"}, delimiter = ':')
    void multiply(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(new Num(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2:2", "4532 / 2123:2"}, delimiter = ':')
    void divide(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(new Num(expected));
    }

    @DisplayName("Test When Input Is Null")
    @Test
    void illegalArgumentExceptionWhenStringIsNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });
    }

    @DisplayName("Test When Input Is Blank")
    @Test
    void illegalArgumentExceptionWhenStringIsBlank() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(" ");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("\t");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("\n");
        });
    }

    @DisplayName("Test When Input Contains Neither Number Nor Sign Character")
    @Test
    void illegalArgumentExceptionWhenStringContainsNeitherNumberNorSignCharacter() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("4 % 2");
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 * 3 / 4 + 2:3", "2 / 3 + 4 * 2:8"}, delimiter = ':')
    void complexOperation(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(new Num(expected));
    }
}
