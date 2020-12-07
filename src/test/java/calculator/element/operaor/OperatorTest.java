package calculator.element.operaor;

import calculator.element.operand.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource({"3,5,8", "6,3,9", "12,3,15"})
    @DisplayName("덧샘 연산 테스트")
    public void add(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Add();
        Operand result = operator.operate(new Operand(inputA), new Operand(inputB));

        assertThat(result.getValue()).isEqualTo(expectedOutput);
    }


    @ParameterizedTest
    @CsvSource({"8,5,3", "2,5,-3", "6,3,3", "12,3,9"})
    @DisplayName("뺄셈 연산 테스트")
    public void minus(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Minus();
        Operand result = operator.operate(new Operand(inputA), new Operand(inputB));

        assertThat(result.getValue()).isEqualTo(expectedOutput);
    }


    @ParameterizedTest
    @CsvSource({"2,5,10", "6,3,18", "12,3,36"})
    @DisplayName("곱셈 연산 테스트")
    public void multiply(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Multiply();
        Operand result = operator.operate(new Operand(inputA), new Operand(inputB));

        assertThat(result.getValue()).isEqualTo(expectedOutput);
    }


    @ParameterizedTest
    @CsvSource({"6,3,2", "12,3,4"})
    @DisplayName("나눗셈 연산 테스트")
    public void division(int inputA, int inputB, int expectedOutput) {
        Operator operator = new Division();
        Operand result = operator.operate(new Operand(inputA), new Operand(inputB));

        assertThat(result.getValue()).isEqualTo(expectedOutput);
    }
}
