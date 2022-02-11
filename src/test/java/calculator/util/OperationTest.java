package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Operation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperationTest {

    @ParameterizedTest
    @CsvSource(value = {"3:7:10", "-1:7:6"}, delimiter = ':')
    void 더하기(double inputNum, double inputNum2, double expected) {
        // when
        double result = Operation.PLUS.apply(inputNum, inputNum2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"7:3:4", "3:7:-4"}, delimiter = ':')
    void 뺴기(double inputNum, double inputNum2, double expected) {
        // when
        double result = Operation.MINUS.apply(inputNum, inputNum2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:7:21", "-1:7:-7"}, delimiter = ':')
    void 곱하기(double inputNum, double inputNum2, double expected) {
        // when
        double result = Operation.TIMES.apply(inputNum, inputNum2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:2:2.5", "6:3:2"}, delimiter = ':')
    void 나누기(double inputNum, double inputNum2, double expected) {
        // when
        double result = Operation.DIVIDE.apply(inputNum, inputNum2);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
