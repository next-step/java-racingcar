package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FactorValidatorTest {
    FactorValidator factorValidator = new FactorValidator();

    @ParameterizedTest()
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void isNotEmptyParameter(String input) {
        assertThatThrownBy(() -> {
                    factorValidator.isNotEmptyParameter(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest()
    @CsvSource({"6 - 123 + 77777777, true", "2 + 3 * 4 / 2, true"})
    void isValidParameter(String input, boolean expect) {
        boolean result = factorValidator.isValidParameter(input);
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"2 + 3 ^ 4 / 2"})
    void isInValidParameter(String input) {
        assertThatThrownBy(() -> {
                    factorValidator.isValidParameter(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}