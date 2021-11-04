package stringcalculator.arithmeticcomponent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("수식을 위한 테스트")
class ArithmeticExpressionTest {

    @DisplayName("1회 연산에 필요한 수식이 정상적으로 생성이 되는지 확인")
    @ParameterizedTest
    @CsvSource({"+,1,2", "-,2,4", "*,3,2", "/,6,2"})
    void initiateArithmeticExpressionTest(String op, String num1, String num2) {
        // Given
        String operator = op;
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);

        // When
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.findByOperator(op);
        ArithmeticOperand arithmeticOperand1 = new ArithmeticOperand(number1);
        ArithmeticOperand arithmeticOperand2 = new ArithmeticOperand(number2);
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(arithmeticOperator, arithmeticOperand1, arithmeticOperand2);

        // Then
        assertThat(arithmeticExpression).isNotNull();
    }

    @DisplayName("1회 연산에 필요한 수식에서 연산자가 없는 경우, 예외를 발생시키는지 확인")
    @ParameterizedTest
    @CsvSource({"1,2", "2,4", "3,2", "6,2"})
    void checkInvalidArithmeticOperatorTest(String num1, String num2) {
        // Given
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);

        // When
        ArithmeticOperand arithmeticOperand1 = new ArithmeticOperand(number1);
        ArithmeticOperand arithmeticOperand2 = new ArithmeticOperand(number2);

        // Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new ArithmeticExpression(null, arithmeticOperand1, arithmeticOperand2)
        );
    }

    @DisplayName("1회 연산에 필요한 수식에서 피연산자가 없는 경우, 예외를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void checkInvalidArithmeticOperandTest(String operator) {
        // When
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.findByOperator(operator);

        // Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new ArithmeticExpression(arithmeticOperator, null, null)
        );
    }
}
