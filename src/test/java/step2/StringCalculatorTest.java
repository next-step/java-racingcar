package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3=5", "2 - 3=-1", "2 * 3=6", "2 / 3=0"}, delimiter = '=')
    @DisplayName("calculate string in each case")
    void calculateStringInEachCase(String input, int expected) {
        assertThat(stringCalculator.calculateString(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 - 4 * 5 / 2=2",
            "1 - 2 * -4 + 1 / 5=1",
            "2 * 3 - 2 / 2 * 1=2",
            "2 * -1 / 2 + 1 - 0=0",
            "1=1"
    }, delimiter = '=')
    @DisplayName("calculate string in complex case")
    void calculateStringInComplexCase(String input, int expected) {
        assertThat(stringCalculator.calculateString(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "    ", "     "})
    @DisplayName("throw IllegalArgumentException when empty blank space is input")
    void throwIllegalArgumentExceptionWhenEmptyBlankSpaceIsInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateString(input);
        });
    }

    @Test
    @DisplayName("throw IllegalArgumentException when null type is input")
    void throwIllegalArgumentExceptionWhenNullTypeIsInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateString(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1", "1 +", "1 + 1 1", "1 + 1 +", "1 / 0",
            "A", "1 A 1", "1 + A", "1 + 1 A 1", "1 + 1 + A"
    })
    @DisplayName("throw IllegalArgumentException when non arithmetic string is input")
    void throwIllegalArgumentExceptionWhenNonArithmeticStringIsInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateString(input);
        });
    }
}
