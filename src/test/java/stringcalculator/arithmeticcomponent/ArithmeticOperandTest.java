package stringcalculator.arithmeticcomponent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수식의 피연산자를 위한 테스트")
class ArithmeticOperandTest {

    @DisplayName("피연산자의 변수로 int 값의 범위 안에 있는 값이 포장 클래스에 할당되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, 1, 100, Integer.MAX_VALUE})
    void checkValidOperandTest(int number) {
        // when
        ArithmeticOperand arithmeticOperand = new ArithmeticOperand(number);
        // then
        assertThat(arithmeticOperand).isNotNull();
        assertThat(arithmeticOperand.number()).isEqualTo(number);
    }
}
