package calculate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormulaTest {
    @Test
    void whenFormulaIsNull() {
        assertThatThrownBy(() -> {
            new Formula(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenFormulaIsBlank() {
        assertThatThrownBy(() -> {
            new Formula(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenFormulaHasIllegalOperator() {
        assertThatThrownBy(() -> {
            new Formula("1 & 1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 / 3 * 4 / 2:0", "2 * 3 / 4 + 2:3", "-1 * -1 + 1 * 2:4"}, delimiter = ':')
    void calculate(String rawFormula, int expectedResult) {
        Formula formula = new Formula(rawFormula);
        assertThat(formula.calculate()).isEqualTo(expectedResult);
    }

    @Test
    void sameFormula() {
        String rawFormula = "2 + 3 * 4 / 2";
        assertThat(new Formula(rawFormula)).isEqualTo(new Formula(rawFormula));
    }
}
