package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step1.Utils.ValidationUtils.isBlankThrowException;
import static step1.Utils.ValidationUtils.isNotNumericThrowException;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void calculatorTest() {
        String input = "2 + 3 * 4 / 2";

        assertThat(stringCalculator.calculate(input)).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void isBlankTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            isBlankThrowException(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "a"})
    void isNotNumericTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            isNotNumericThrowException(input);
        });
    }
}
