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
    void validInputWord() {
        Assertions.assertThatThrownBy(() -> {
            StringCalculator.of("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}