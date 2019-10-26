package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("FormulaParser should")
class FormulaParserTest {

    @Test
    @DisplayName("throw IllegalArgumentException when input is empty formula string")
    void shouldThrowExceptionWhenInputIsEmtpyString() {
        final String emtpyFormula = "";
        final Formula formula = FormulaParserFactory.sequential().parse(emtpyFormula);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            formula.calculate();
        });
    }
}