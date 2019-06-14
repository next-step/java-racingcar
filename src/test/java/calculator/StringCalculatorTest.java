package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    private String input = "2 + 3 * 4 / 2";

    @Test
    void parseString() {
        assertThat(StringCalculator.parseString(input))
                .containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void parseWrongString() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.parseString("2 + 3 *"));
    }

    @Test
    void calculate() {
        assertThat(StringCalculator.calculate(input)).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void getValidSymbol(String symbol) {
        assertThat(StringCalculator.getSymbolType(symbol).name()).isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$"})
    void getNotValidSymbolThrowIllegalArgumentException(String symbol) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringCalculator.getSymbolType(symbol));
    }
}
