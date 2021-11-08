package com.kakao.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @Test
    @DisplayName("올바른 순서로 Expression을 만들면 계산에 성공한다")
    void expression() {
        Expression expression = new Expression(new String[]{"2", "+", "1"});
        Operand execute = expression.execute();
        assertThat(execute).isEqualTo(new Operand(3.0));
    }

    @Test
    @DisplayName("식을 완성하지 않고 Expression을 만들면 실패")
    void exception1() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(new String[]{"2", "+"}));
    }

    @Test
    @DisplayName("연산자와 피연산자의 순서를 올바르게 하지 않고 Expression을 만들어 계산하면 실패")
    void exception2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(new String[]{"2", "+", "+"}).execute());
    }
}
