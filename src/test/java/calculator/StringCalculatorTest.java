package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;
    private StringValidator validator;

    @BeforeEach
    void init() {
        calculator = new StringCalculator();
        validator = new StringValidator();
    }

    @Test
    void plus() {
        int result = calculator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minus() {
        int result = calculator.minus(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        int result = calculator.multiply(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divide() {
        int result = calculator.divide(5, 3);
        assertThat(result).isEqualTo(1);
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void validationBlank(String input) {
        boolean result = validator.valid(input);
        assertThat(result).isFalse();
    }

    static Stream<String> notOperationSymbols() {
        return Stream.of("&", "^", "%", "f");
    }

    @ParameterizedTest
    @MethodSource("notOperationSymbols")
    void validationOperationSymbol(String symbol) {
        boolean result = validator.valid(symbol);
        assertThat(result).isFalse();
    }

    @Test
    void calculator() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

}