package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2:2", "1,0:0", "-1,2:-2", "-2,-5:10"}, delimiter = ':')
    void multiply_operation_test(String input, String expected) {
        Multiply multiply = new Multiply();

        int[] operands  = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int expectedAnswer = Integer.parseInt(expected);

        assertThat(multiply.operate(operands[0], operands[1])).isEqualTo(expectedAnswer);
    }

}