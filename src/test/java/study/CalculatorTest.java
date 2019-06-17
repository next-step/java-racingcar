package study;

import calcurator.Calculator;
import calcurator.Operation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorAdd(int a, int b) {
        assertThat(Calculator.add(a, b)).isEqualTo(3);
    }


    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorSubtract(int a, int b) {
        assertThat(Calculator.subtract(a, b)).isEqualTo(-1);
    }


    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorMultiply(int a, int b) {
        assertThat(Calculator.multiply(a, b)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorDivision(int a, int b) {
        assertThat(Calculator.division(a, b)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@"})
    void testInvalidOperation(String operation) {
        assertThat(Operation.isValidOperation(operation)).isEqualTo(false);
    }


}
