
package study;

import study.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "2 + 8 / 5 * 2 + 3"})
    void calculator_joseph(final String string) {
        Calculator cal1 = new Calculator();
        System.out.println(cal1.calculator(string));
    }
}