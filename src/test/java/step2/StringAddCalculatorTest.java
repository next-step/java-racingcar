package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {
    private final StringAddCalculator calculator = new StringAddCalculator();
    @ParameterizedTest
    @CsvSource(ignoreLeadingAndTrailingWhitespace = false, delimiter = '\t', value = {
            "\t0",
            " \t0",
            "1\t1",
            "1,2\t3",
            "1,2:3\t6",
    })
    void Given_ValidString_When_SplitAndSum_Then_Calculate(String calculatorString, int expected) {
        int result = calculator.splitAndSum(calculatorString);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void Given_CustomDelimiter_When_SplitAndSum_Then_Calculate() {
        String calculatorString = "//;\n1;2;3"; // @CsvSource can't handle new lines only java.

        int result = calculator.splitAndSum(calculatorString);

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "-1,a,b,2"})
    void Given_InvalidString_When_SplitAndSum_Then_ThrowError(String calculatorString) {
        try {
            calculator.splitAndSum(calculatorString);

            fail(new RuntimeException());
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }
}
