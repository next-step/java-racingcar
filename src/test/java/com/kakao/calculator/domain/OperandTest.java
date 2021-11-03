package com.kakao.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandTest {

    @Test
    @DisplayName("입력받은 문자열을 Operand 클래스로 만든다")
    void operandConstructor() {
        Operand operand = Operand.of("1");
        assertThat(operand.getValue()).isEqualTo(1.0);
    }

    @Test
    @DisplayName("올바르지 않은 문자열을 Operand로 만드려하면 에러가 발생한다.")
    void operandException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operand.of("*"));
    }

    @Test
    @DisplayName("Operand가 제공하는 메서드를 이용하여 Operand간의 연산을 할 수 있다.")
    void operandProcess() {
        Operand operand1 = new Operand(6.0);
        Operand operand2 = new Operand(2.0);

        Operand plus = operand1.plus(operand2);
        Operand minus = operand1.minus(operand2);
        Operand multiple = operand1.multiple(operand2);
        Operand divide = operand1.divide(operand2);

        assertThat(plus.getValue()).isEqualTo(8.0);
        assertThat(minus.getValue()).isEqualTo(4.0);
        assertThat(multiple.getValue()).isEqualTo(12.0);
        assertThat(divide.getValue()).isEqualTo(3.0);
    }

    @Test
    @DisplayName("Operand안의 value 값이 같으면 같은 객체이다.")
    void equals() {
        Operand operand1 = new Operand(1.0);
        Operand operand2 = new Operand(1.0);

        assertThat(operand1).isEqualTo(operand2);
    }
}
