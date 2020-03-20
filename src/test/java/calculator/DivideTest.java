package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class DivideTest {

    private Divide divide;

    @BeforeEach
    void setup() {
        divide = new Divide();
    }

    @ParameterizedTest
    @CsvSource(value = {"4,2:2", "1,-1:-1", "-2,-5:0",}, delimiter = ':')
    void divide_operation_test(String input, String expected) {
        int[] operands  = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int expectedAnswer = Integer.parseInt(expected);

        assertThat(divide.operate(operands[0], operands[1])).isEqualTo(expectedAnswer);
    }

    @Test
    @DisplayName("0 으로 나누면 ArithmeticException")
    void divide_by_zero_test() {
        assertThatThrownBy(() -> divide.operate(2, 0)).isInstanceOf(ArithmeticException.class);
    }

}