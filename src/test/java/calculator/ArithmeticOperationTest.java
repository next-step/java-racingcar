package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ArithmeticOperationTest {

    private final String PLUS = ArithmeticOperation.PLUS.getExpression();
    private final String MINUS = ArithmeticOperation.MINUS.getExpression();
    private final String MULTIPLICATION = ArithmeticOperation.MULTIPLICATION.getExpression();
    private final String DIVISION = ArithmeticOperation.DIVISION.getExpression();

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

    @DisplayName("사칙 연산 enum 값 찾기")
    @Test
    public void findMatchedExpression() throws Exception {
        //then
        assertThat(ArithmeticOperation.findMatchedExpression(PLUS)).isEqualTo(ArithmeticOperation.PLUS);
        assertThat(ArithmeticOperation.findMatchedExpression(MINUS)).isEqualTo(ArithmeticOperation.MINUS);
        assertThat(ArithmeticOperation.findMatchedExpression(MULTIPLICATION)).isEqualTo(ArithmeticOperation.MULTIPLICATION);
        assertThat(ArithmeticOperation.findMatchedExpression(DIVISION)).isEqualTo(ArithmeticOperation.DIVISION);
    }

    @DisplayName("사칙연산 테스트")
    @Test
    public void calculateInput() throws Exception {
        //given
        double num1 = 1;
        double num2 = 2;
        //then
        assertAll(
                () -> assertThat((ArithmeticOperation.calculateInput(num1, num2, "+"))).isEqualTo(3),
                () -> assertThat(ArithmeticOperation.calculateInput(num1, num2, "-")).isEqualTo(-1),
                () -> assertThat(ArithmeticOperation.calculateInput(num2, num2, "*")).isEqualTo(4),
                () -> assertThat(ArithmeticOperation.calculateInput(num2, num2, "/")).isEqualTo(1),
                () -> assertThat(ArithmeticOperation.calculateInput(num2, num2, "+")).isNotEqualTo(1)
        );
    }
}
