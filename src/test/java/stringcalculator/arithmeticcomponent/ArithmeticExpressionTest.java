package stringcalculator.arithmeticcomponent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("수식을 위한 테스트")
class ArithmeticExpressionTest {

    @DisplayName("1회 연산에 필요한 수식이 정상적으로 생성이 되는지 확인")
    @ParameterizedTest
    @CsvSource({"1,+,2", "2,-,4", "3,*,2", "6,/,2"})
    void initiateArithmeticExpressionTest(int num1, String op, int num2) {
        // when
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(
                new ArithmeticOperand(num1),
                ArithmeticOperator.findByOperator(op),
                new ArithmeticOperand(num2)
        );
        // then
        assertThat(arithmeticExpression.operator()).isEqualTo(ArithmeticOperator.findByOperator(op));
        assertThat(arithmeticExpression.operand1().number()).isEqualTo(num1);
        assertThat(arithmeticExpression.operand2().number()).isEqualTo(num2);
    }

    @DisplayName("수식에 대한 결과 확인")
    @ParameterizedTest
    @MethodSource("provideMultipleExpressionAndResult")
    void checkResultOfExpressionTest(int num1, String op, int num2, int result) {
        // when
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(
                new ArithmeticOperand(num1),
                ArithmeticOperator.findByOperator(op),
                new ArithmeticOperand(num2)
        );
        // then
        assertThat(arithmeticExpression.result()).isEqualTo(new ArithmeticResult(result));
    }

    @DisplayName("1회 연산에 필요한 수식에서 연산자가 없는 경우, 예외를 발생시키는지 확인")
    @ParameterizedTest
    @CsvSource({"1,2", "2,4", "3,2", "6,2"})
    void checkInvalidArithmeticOperatorTest(int num1, int num2) {
        // when
        ArithmeticOperand arithmeticOperand1 = new ArithmeticOperand(num1);
        ArithmeticOperand arithmeticOperand2 = new ArithmeticOperand(num2);
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new ArithmeticExpression(arithmeticOperand1, null, arithmeticOperand2)
        );
    }

    @DisplayName("1회 연산에 필요한 수식에서 피연산자가 없는 경우, 예외를 발생시키는지 확인")
    @ParameterizedTest
    @EnumSource(value = ArithmeticOperator.class)
    void checkInvalidArithmeticOperandTest(ArithmeticOperator operator) {
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new ArithmeticExpression(null, operator, null)
        );
    }

    static Stream provideMultipleExpressionAndResult() {
        return Stream.of(
                Arguments.of(1, "+", 2, 3),
                Arguments.of(3, "-", 2, 1),
                Arguments.of(4, "*", 2, 8),
                Arguments.of(4, "/", 2, 2)
        );
    }
}
