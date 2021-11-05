package calculate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 / 3 * 4 / 2:0", "2 * 3 / 4 + 2:3"}, delimiter = ':')
    void composite(String composite, int expectedResult) {
        Formula formula = new Formula(composite);
        assertThat(formula.calculate()).isEqualTo(expectedResult);
    }
}
