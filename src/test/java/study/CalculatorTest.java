package study;

import calcurator.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorAdd(int a, int b) {
        assertThat(Calculator.ADD.getCalculate().apply(a, b)).isEqualTo(3);
    }


    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorSubtract(int a, int b) {
        assertThat(Calculator.SUBTRACT.getCalculate().apply(a, b)).isEqualTo(-1);
    }


    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorMultiply(int a, int b) {
        assertThat(Calculator.MULTIPLY.getCalculate().apply(a, b)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"1, 2"})
    void testCalculatorDivision(int a, int b) {
        assertThat(Calculator.DIVISION.getCalculate().apply(a, b)).isEqualTo(0);
    }

}
