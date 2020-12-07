package calculator.element.operaor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorFactoryTest {

    @Test
    @DisplayName("연산자 문자 키로 연산자들을 잘 찾아오는지 테스트")
    void getOperatorTest() {
        Operator operator = OperatorFactory.getOperator("+");
        assertThat(operator).isInstanceOf(Add.class);

        operator = OperatorFactory.getOperator("-");
        assertThat(operator).isInstanceOf(Minus.class);

        operator = OperatorFactory.getOperator("*");
        assertThat(operator).isInstanceOf(Multiply.class);

        operator = OperatorFactory.getOperator("/");
        assertThat(operator).isInstanceOf(Division.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"?", "^", "@",})
    @DisplayName("제공되지 않는 문자 키 입력시 IllegalArgumentException 발생")
    void getOperatorExceptionTest(String operatorKey) {
        assertThatThrownBy(() -> {
            OperatorFactory.getOperator(operatorKey);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}