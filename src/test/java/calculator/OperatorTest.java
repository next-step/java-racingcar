package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperatorTest {
    Num first;
    Num second;
    private String INPUT_SPLIT_REGEX = ",";

    @ParameterizedTest
    @CsvSource(value = {"7,2:9", "4532,2123:6655"}, delimiter = ':')
    void addition(String input, int expected) {
        getInputs(input);
        assertThat(Operator.of("+").operate(first, second)).isEqualTo(new Num(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"7,2:5", "4532,2123:2409"}, delimiter = ':')
    void subtraction(String input, int expected) {
        getInputs(input);
        assertThat(Operator.of("-").operate(first, second)).isEqualTo(new Num(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"7,2:14", "4532,2123:9621436"}, delimiter = ':')
    void multiplication(String input, int expected) {
        getInputs(input);
        assertThat(Operator.of("*").operate(first, second)).isEqualTo(new Num(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"7,2:3", "4532,2123:2"}, delimiter = ':')
    void division(String input, int expected) {
        getInputs(input);
        assertThat(Operator.of("/").operate(first, second)).isEqualTo(new Num(expected));
    }

    private void getInputs(String input) {
        String[] inputs = input.split(INPUT_SPLIT_REGEX);
        first = new Num(inputs[0]);
        second = new Num(inputs[1]);
    }
}
