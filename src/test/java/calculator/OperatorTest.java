package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    @DisplayName("연산기호가 아닌 값이 들어왔을 때, 예외를 생성한다.")
    void 연산자_오류() {
        assertThatThrownBy(() -> Operator.findOperand("?"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}