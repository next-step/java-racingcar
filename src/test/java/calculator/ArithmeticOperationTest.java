package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ArithmeticOperationTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "1:3:4"}, delimiter = ':')
    public void plus(double operand1, double operand2, double expect) throws Exception {
        //then
        assertThat(ArithmeticOperation.PLUS.calculate(operand1, operand2)).isEqualTo(expect);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "10:3:7"}, delimiter = ':')
    public void minus(double operand1, double operand2, double expect) throws Exception {
        //then
        assertThat(ArithmeticOperation.MINUS.calculate(operand1, operand2)).isEqualTo(expect);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "10:3:30"}, delimiter = ':')
    public void multiplication(double operand1, double operand2, double expect) throws Exception {
        //then
        assertThat(ArithmeticOperation.MULTIPLICATION.calculate(operand1, operand2)).isEqualTo(expect);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:0.5", "30:3:10"}, delimiter = ':')
    public void division(double operand1, double operand2, double expect) throws Exception {
        //then
        assertThat(ArithmeticOperation.DIVISION.calculate(operand1, operand2)).isEqualTo(expect);
    }
}
