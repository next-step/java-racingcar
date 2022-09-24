package step2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorStringTest {
    @ParameterizedTest
    @CsvSource(ignoreLeadingAndTrailingWhitespace = false, delimiter = '\t', value = {
            "1\t1\t ",
            "1,2\t1,2\t,",
            "1:2\t1:2\t:",
            "1,2:3\t1,2:3\t,|:"
    })
    void Given_ValidString_When_Create_CalculatorString_Then_Created(String input, String expectedText, String expectedDelimiter) {
        CalculatorString actual = CalculatorString.of(input);

        assertThat(actual.getText()).isEqualTo(expectedText);
        assertThat(actual.getDelimiter()).isEqualTo(expectedDelimiter);
    }

    @Test
    void Given_CustomDelimiterWithString_When_Create_CalculatorString_Then_Created() {
        String input = "//;\n1;2;3";
        CalculatorString actual = CalculatorString.of(input);

        assertThat(actual.getText()).isEqualTo("1;2;3");
        assertThat(actual.getDelimiter()).isEqualTo(";");
    }

    @ParameterizedTest
    @CsvSource(ignoreLeadingAndTrailingWhitespace = false, value = {
            ",true",
            " ,true",
            "1,false"
    })
    void Given_String_When_CallEmptyMethod_Then_ReturnProperly(String string, boolean expected) {
        CalculatorString calculatorString = CalculatorString.of(string);

        assertThat(calculatorString.empty()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(ignoreLeadingAndTrailingWhitespace = false, value = {
            ",false",
            " ,false",
            "1,true",
            "1:2,false"
    })
    void Given_String_When_CallNumeralMethod_Then_ReturnProperly(String string, boolean expected) {
        CalculatorString calculatorString = CalculatorString.of(string);

        assertThat(calculatorString.numeral()).isEqualTo(expected);
    }
}
