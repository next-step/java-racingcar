package calculator;

import calculator.domain.Operation;
import calculator.domain.StringsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void blankTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> StringsService.isBlank(input));
    }

    @Test
    public void checkSymbolTest() {
        String[] splitBlank = {"2", "+", "3", "*", "4", "/", "2"};
        assertThat(StringsService.checkSymbol(splitBlank)).isTrue();
    }

    @Test
    public void calculateSplitedString() {
        String[] splitBlank = {"2", "+", "3", "*", "4", "/", "2"};
        int result = StringsService.calculateSplitedString(splitBlank);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 연산식을_수행한다() {

        assertThat(5).isEqualTo(연산_기호를_찾는다("+").result(2, 3));
    }

    private Operation 연산_기호를_찾는다(String symbol) {
        return Operation.findBySymbol(String.valueOf(symbol));
    }
}
