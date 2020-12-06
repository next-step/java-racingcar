package calculator.operaor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource({"3,5,8", "6,3,9", "12,3,15"})
    public void add(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Add();
        int result = operator.operate(inputA, inputB);

        assertThat(result).isEqualTo(expectedOutput);
    }


    @ParameterizedTest
    @CsvSource({"8,5,3", "2,5,-3", "6,3,3", "12,3,9"})
    public void minus(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Minus();
        int result = operator.operate(inputA, inputB);

        assertThat(result).isEqualTo(expectedOutput);
    }


    @ParameterizedTest
    @CsvSource({"2,5,10", "6,3,18", "12,3,36"})
    public void multiply(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Multiply();
        int result = operator.operate(inputA, inputB);

        assertThat(result).isEqualTo(expectedOutput);
    }


    @ParameterizedTest
    @CsvSource({"6,3,2", "12,3,4"})
    public void division(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Division();
        int result = operator.operate(inputA, inputB);

        assertThat(result).isEqualTo(expectedOutput);
    }
}
