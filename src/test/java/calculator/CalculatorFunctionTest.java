package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorFunctionTest {
    @Test
    void additionTest() {
        CalculatorFunction calculatorFunction = new CalculatorFunction();
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculatorFunction.addNumber(first,second)).isEqualTo(7);
    }

    @Test
    void subtractionTest() {
        CalculatorFunction calculatorFunction = new CalculatorFunction();
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculatorFunction.subtractNumber(first,second)).isEqualTo(-1);
    }

    @Test
    void multiplicationTest() {
        CalculatorFunction calculatorFunction = new CalculatorFunction();
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculatorFunction.multipleNumber(first,second)).isEqualTo(12);
    }

    @Test
    void divisionTest() {
        CalculatorFunction calculatorFunction = new CalculatorFunction();
        int first = 12;
        int second = 4;
        Assertions.assertThat(calculatorFunction.divideNumber(first,second)).isEqualTo(3);
    }
}
