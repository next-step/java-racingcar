package study;

import calculator.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {


    @ParameterizedTest
    @ValueSource(strings = { "2 + 8 / 5 * 2 ", "20 - 5 / 2 * 2 "})
    void caculator( String input) throws Exception {
        Calculator  ca = new Calculator();
        int result =  ca.excute(input);
        System.out.println(result);
    }

}
