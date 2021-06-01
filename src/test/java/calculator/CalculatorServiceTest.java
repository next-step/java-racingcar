package calculator;

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
}
