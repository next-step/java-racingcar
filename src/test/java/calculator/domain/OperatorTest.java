package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {
    @DisplayName("연산자 확인")
    @Test
    void 연산자_확인() {
        assertThat(Operator.isOperator(".")).isFalse();
        assertThat(Operator.isOperator("+")).isTrue();
        assertThat(Operator.isOperator("-")).isTrue();
        assertThat(Operator.isOperator("*")).isTrue();
        assertThat(Operator.isOperator("/")).isTrue();
    }

    @DisplayName("계산 결과 확인")
    @Test
    void 계산_확인() {
        assertThat(Operator.getType("+").operate(1, 2)).isEqualTo(3);
        assertThat(Operator.getType("*").operate(3, 4)).isEqualTo(12);
        assertThat(Operator.getType("-").operate(6, 5)).isEqualTo(1);
        assertThat(Operator.getType("/").operate(10, 5)).isEqualTo(2);
    }


}