package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 필터링 확인")
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MUL", "/,DIV"}, delimiter = ',')
    void find(String sign, Operator expectedOperator) {
        Operator operator = Operator.find(sign);
        assertThat(operator).isEqualTo(expectedOperator);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 값 확인")
    @CsvSource(value = {"+,3,6,9", "-,10,1,9", "*,14,2,28", "/,14,7,2"}, delimiter = ',')
    void operate(String operator, int operand1, int operand2, int expected) {
        int result = Operator.operation(operator, operand1, operand2);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈에서 0을 나누는 경우 예외 테스트")
    void operateException(){
        assertThatThrownBy(
                () ->  Operator.operation("/", 10, 0)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}
