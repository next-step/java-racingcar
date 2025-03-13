import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringPlusCalculatorTest {

    private StringPlusCalculator cut = new StringPlusCalculator();

    @ParameterizedTest
    @CsvSource({
            "'',''",
            "'1,2',''",
            "'1,2,3',''",
            "'1,2:3',''",
            "'//;\n1;2;3',';'",
    })
    void getSeperator(String input, String seperator) {
        assertEquals(seperator, cut.getSeperator(input));
    }

    @ParameterizedTest
    @CsvSource({
            "'',0",
            "'1,2',3",
            "'1,2,3',6",
            "'1,2:3',6",
            "'//;\n1;2;3',6",
    })
    void seperateByDefault(String input, int result) {
        assertEquals(result, cut.calculate(input));
    }
}
