package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ArithmeticExpressionTest {

    @ParameterizedTest(name = "입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    @NullAndEmptySource
    public void invalidInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ArithmeticExpression.of(input))
                .withMessageContaining(String.format("입력 값이 유효하지 않습니다. %s", input));
    }

    @ParameterizedTest(name = "연산자가 하나인 경우 hasOnlyOneOperator가 true를 반환한다.")
    @CsvSource(value = {"1 + 2, true", "1 + 2 + 3, false"})
    public void hasOnlyOneOperatorTest(String input, boolean result) {
        ArithmeticExpression expression = ArithmeticExpression.of(input);
        assertThat(expression.hasOnlyOneOperator()).isEqualTo(result);
    }

    @ParameterizedTest(name = "getFirstNumber는 연산식의 첫번쨰 숫자를 반환한다.")
    @CsvSource(value = {"1 + 2, 1", "2 + 3 - 4, 2"})
    public void getFirstNumberTest(String input, int firstNumber) {
        ArithmeticExpression expression = ArithmeticExpression.of(input);
        assertThat(expression.getFirstNumber()).isEqualTo(firstNumber);
    }

    @ParameterizedTest(name = "getLastNumber는 연산식의 마지막 숫자를 반환한다.")
    @CsvSource(value = {"1 + 2, 2", "2 + 3 - 4, 4"})
    public void getLastNumberTest(String input, int lastNumber) {
        ArithmeticExpression expression = ArithmeticExpression.of(input);
        assertThat(expression.getLastNumber()).isEqualTo(lastNumber);
    }

    @ParameterizedTest(name = "getLastOperator는 연산식의 마지막 연산자를 반환한다.")
    @CsvSource(value = {"1 + 2, ADDITION", "2 + 3 - 4, SUBTRACTION"})
    public void getLastOperatorTest(String input, Operator operator) {
        ArithmeticExpression expression = ArithmeticExpression.of(input);
        assertThat(expression.getLastOperator()).isEqualTo(operator);
    }

}