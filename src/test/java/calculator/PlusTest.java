package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlusTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "-1,1:0", "0,0:0", "-2,-5:-7",}, delimiter = ':')
    void plus_operation_test(String input, String expected) {
        Plus plus = new Plus();

        int[] operands  = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int expectedAnswer = Integer.parseInt(expected);
        assertThat(plus.operate(operands[0], operands[1])).isEqualTo(expectedAnswer);
    }

}