package com.kakao.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    @DisplayName("문자열을 받으면 해당하는 연산자 타입을 반환한다")
    void getValue() {
        Operator plus = Operator.of("+");
        assertThat(plus).isEqualTo(Operator.PLUS);
    }

    @Test
    @DisplayName("Operator에 해당하는 연산을 수행한다.")
    void operatorExecute() {
        Operand operand1 = new Operand(6.0);
        Operand operand2 = new Operand(2.0);

        Operand plus = Operator.PLUS.operation(operand1, operand2);
        Operand minus = Operator.MINUS.operation(operand1, operand2);
        Operand multiple = Operator.MULTIPLE.operation(operand1, operand2);
        Operand divide = Operator.DIVIDE.operation(operand1, operand2);

        assertThat(plus.getValue()).isEqualTo(8.0);
        assertThat(minus.getValue()).isEqualTo(4.0);
        assertThat(multiple.getValue()).isEqualTo(12.0);
        assertThat(divide.getValue()).isEqualTo(3.0);
    }

    @Test
    @DisplayName("나누기를 했을 때 0으로 나누면 에러를 발생시킨다")
    void divideException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDE.operation(new Operand(2.0), new Operand(0.0)));
    }

    @Test
    @DisplayName("문자열을 받았을 때 알맞은 연산자 타입이 아니면 에러를 발생시킨다")
    void getValueException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of("="));
    }

}
