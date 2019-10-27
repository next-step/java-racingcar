package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("FormulaParser should")
class FormulaParserTest {

    @Test
    @DisplayName("throw exception when input is empty formula string")
    void shouldThrowExceptionWhenInputIsEmtpyString() {
        final String emtpyFormula = "";

        assertThatExceptionOfType(IllegalFormulaFormatException.class)
                .isThrownBy(() -> FormulaParserFactory.sequentialInteger().parse(emtpyFormula));
    }

    @Test
    @DisplayName("throw exception when input has just one operator")
    void throwExceptionWhenDivideByZero() {
        final String soloFormulaNode = "/";

        assertThatExceptionOfType(IllegalFormulaFormatException.class)
                .isThrownBy(() -> FormulaParserFactory.sequentialInteger().parse(soloFormulaNode));
    }

    @Test
    @DisplayName("throw exception values and operators are not matched")
    void throwExceptionValuesAndOperatorsAreNotMatched() {
        final String invalidFormula = "1 + 2 + ";

        assertThatExceptionOfType(IllegalFormulaFormatException.class)
                .isThrownBy(() -> FormulaParserFactory.sequentialInteger().parse(invalidFormula));
    }
}