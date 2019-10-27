package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Formula should")
class FormulaTest {
    @Test
    @DisplayName("return as same as input when it has only one value")
    void shouldReturnEqualValueWhenInputFormulaNodeIsOne() {
        final String soloFormulaNode = "1";
        final Formula formula = FormulaParserFactory.sequentialInteger().parse(soloFormulaNode);

        assertThat(formula.evaluate().asInt())
                .isEqualTo(Integer.parseInt(soloFormulaNode));
    }

    @Test
    @DisplayName("throw exception when divide by 0")
    void throwExceptionWhenDivideByZero() {
        final String soloFormulaNode = "1 / 0";
        final Formula formula = FormulaParserFactory.sequentialInteger().parse(soloFormulaNode);

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(formula::evaluate);
    }

    @Test
    @DisplayName("return valid evaluated value")
    void returnValidEvaluatedValue() {
        final String soloFormulaNode = "1 + 5 * 5 + 2";
        final Formula formula = FormulaParserFactory.sequentialInteger().parse(soloFormulaNode);

        assertThat(formula.evaluate().asInt())
                .isEqualTo(32);
    }
}