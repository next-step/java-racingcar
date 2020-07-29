package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    void computeWithExpectValue(String text, int expect) {
        assertThat(calculator.compute(text)).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "2 + 3 * 4 & 2"})
    void computeWithException(String text) {
        assertThatThrownBy(() -> {
            calculator.compute(text);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}