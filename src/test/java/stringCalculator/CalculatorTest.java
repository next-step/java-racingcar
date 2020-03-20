package stringCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 + 2:5.0 + 2", "1 / 2 + 2:0.5 + 2"}, delimiter = ':')
    void assembleFormulaTest(String input, String expected) {
        Calculator calulator = new Calculator(input);
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList(expected.split(" ")));

        ArrayList<String> formula = calulator.assembleFormula();

        assertThat(formula).isEqualTo(expectedList);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10.0", "7 / 14 * 7 + 7:10.5", "9 / 3 * 2 * 5:30.0"}, delimiter = ':')
    void workTest(String input, String expected) {
        Calculator calulator = new Calculator(input);

        Double result = calulator.work();

        assertThat(result).isEqualTo(Double.valueOf(expected));
    }
}
