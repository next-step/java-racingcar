package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("return as same as input when it has only one formula node")
    void shouldReturnEqualValueWhenInputFormulaNodeIsOne() {
        final String soloFormulaNode = "1";
        final Formula formula = FormulaParserFactory.sequential().parse(soloFormulaNode);

        final int actual = formula.calculate();
        final int expected = Integer.parseInt(soloFormulaNode);
        assertThat(actual).isEqualTo(expected);
    }
}