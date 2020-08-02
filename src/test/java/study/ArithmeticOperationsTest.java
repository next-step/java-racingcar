package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,3,5", "4,5,9"})
    void addition(int value1, int value2, int expectValue) {
        ArithmeticOperations operations = ArithmeticOperations.ADDITION;

        Integer result = operations.calculate(value1, value2);

        assertThat(result).isEqualTo(expectValue);
    }

    @ParameterizedTest
    @CsvSource({"5,3,2", "2,3,-1", "10,7,3"})
    void subtraction(int value1, int value2, int expectValue) {
        ArithmeticOperations operations = ArithmeticOperations.SUBTRACTION;

        Integer result = operations.calculate(value1, value2);

        assertThat(result).isEqualTo(expectValue);
    }

    @ParameterizedTest
    @CsvSource({"5,3,15", "2,3,6", "10,7,70"})
    void multiplication(int value1, int value2, int expectValue) {
        ArithmeticOperations operations = ArithmeticOperations.MULTIPLICATION;

        Integer result = operations.calculate(value1, value2);

        assertThat(result).isEqualTo(expectValue);
    }

    @ParameterizedTest
    @CsvSource({"10,2,5", "30,4,7", "10,7,1", "0,10,0"})
    void division(int value1, int value2, int expectValue) {
        ArithmeticOperations operations = ArithmeticOperations.DIVISION;

        Integer result = operations.calculate(value1, value2);

        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    void divisionByZero() {
        ArithmeticOperations operations = ArithmeticOperations.DIVISION;

        assertThatThrownBy(()->operations.calculate(10, 0))
                .isInstanceOf(IllegalArgumentException.class);

    }
}