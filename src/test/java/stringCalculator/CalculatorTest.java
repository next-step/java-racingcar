package stringCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 + 2:3 + 2"}, delimiter = ':')
    void assembleFormulaTest(String input, String expected) {
        Calculator calulator = new Calculator(input);
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList(expected.split(" ")));

        ArrayList<String> formula = calulator.assembleFormula(inputStringList);

        assertThat(formula.toString()).isEqualTo(expectedList);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10.0"}, delimiter = ':')
    void workTest(String input, String expected) {
        Calculator calulator = new Calculator(input);

        Double result = calulator.work();

        assertThat(result).isEqualTo(expected);
    }
}
