import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringPlusCalculatorTest {

    private StringPlusCalculator stringPlusCalculator = new StringPlusCalculator();

    @ParameterizedTest
    @CsvSource({
            "'',0",
            "'1,2',3",
            "'1,2,3',6",
            "'1,2:3',6",
            "'//;\n1;2;3',6",
    })
    void seperateByDefault(String input, int result) {
        assertEquals(result, stringPlusCalculator.calculate(input));
    }
}
