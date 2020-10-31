package stringCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource("3,5")
    public void 덧셈(int first, int second){
        assertThat(calculator.addition(first,second)).isEqualTo(8);
    }

    @ParameterizedTest
    @CsvSource("10,5")
    public void 뺄셈(int first, int second){
        assertThat(calculator.substract(first,second)).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource("10,20")
    public void 곱셈(int first, int second){
        assertThat(calculator.multiplication(first,second)).isEqualTo(200);
    }

    @ParameterizedTest
    @CsvSource("100,5")
    public void 나눗셈(int first, int second){
        assertThat(calculator.divide(first,second)).isEqualTo(20);
    }

}
