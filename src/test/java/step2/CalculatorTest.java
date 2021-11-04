package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.MyNumber;
import step2.model.Calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @DisplayName("add method test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1 - 5 + 10:7","100 * 100:10000"},delimiter = ':')
    public void calculator(String str, int expect ) {
        assertTrue(Calculator.operator(str).equals(new MyNumber(expect)));
    }

    @Test
    void add() {
        MyNumber mynumber = new MyNumber("1").add(new MyNumber(2));
        assertTrue(mynumber.equals(new MyNumber(3)));
    }

    @Test
    void minus() {
        MyNumber mynumber = new MyNumber("5").minus(new MyNumber(1));
        assertTrue(mynumber.equals(new MyNumber(4)));
    }

    @Test
    void multiply() {
        MyNumber mynumber = new MyNumber("12").multiply(new MyNumber(12));
        assertTrue(mynumber.equals(new MyNumber(144)));
    }

    @Test
    void divide() {
        MyNumber mynumber = new MyNumber("33").add(new MyNumber(3));
        assertTrue(mynumber.equals(new MyNumber(11)));
    }
}
