package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinusTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2:-1", "1,-1:2", "0,0:0", "-2,-5:3",}, delimiter = ':')
    void minus_operation_test(String input, String expected) {
        Minus minus = new Minus();

        int[] operands  = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int expectedAnswer = Integer.parseInt(expected);

        assertThat(minus.operate(operands[0], operands[1])).isEqualTo(expectedAnswer);
    }

}