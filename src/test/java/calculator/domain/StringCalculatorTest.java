package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void of() {
        Assertions.assertThat(StringCalculator.of("2 + 3 * 4 / 2").toString())
                .isEqualTo(("10.0"));
    }

    @Test
    void splitWord() {
        Assertions.assertThat(StringCalculator.splitWord("2 + 3 * 4 / 2").length)
                .isEqualTo(7);
        Assertions.assertThat(StringCalculator.splitWord("2 + 3 * 4 / 2"))
                .containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void calculate() {
        Assertions.assertThat(StringCalculator.of("2").calculate(new String[] {"2", "+", "3", "*", "4", "/", "2"}))
                .isEqualTo(10);
    }

    @Test
    void validInputWord() {
        Assertions.assertThatThrownBy(() -> {
            StringCalculator.validInputWord("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}