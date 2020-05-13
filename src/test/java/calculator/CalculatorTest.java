package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "2,2,4", "-1,-5,-6"})
    void add(double a, double b, double expected) {
        double result = Calculator.add(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,-1", "2,2,0", "5,3,2"})
    void sub(double a, double b, double expected) {
        double result = Calculator.sub(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,2", "2,2,4", "0,2,0"})
    void mul(double a, double b, double expected) {
        double result = Calculator.mul(a, b);
        assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value={"2,2,1", "0,3,0", "6,3,2"})
    void div(double a, double b, double expected) {
        double result = Calculator.div(a, b);
        assertEquals(expected, result);
    }
}
