package calculator.deque;

import calculator.element.operand.Operand;
import calculator.element.operaor.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ElementDequeTest {

    @Test
    @DisplayName("ElementDeque 에서 순서대로 popOperand, popOperator 하는지 테스트")
    public void popTest() {
        String input = "1 + 2 * 3 - 4";
        String[] split = input.split(" ");
        ElementDeque elementDeque = new ElementDeque(split);

        Operand operand = elementDeque.popOperand();
        assertThat(operand.getValue()).isEqualTo(1);

        Operator operator = elementDeque.popOperator();
        assertThat(operator).isInstanceOf(Add.class);

        operand = elementDeque.popOperand();
        assertThat(operand.getValue()).isEqualTo(2);

        operator = elementDeque.popOperator();
        assertThat(operator).isInstanceOf(Multiply.class);

        operand = elementDeque.popOperand();
        assertThat(operand.getValue()).isEqualTo(3);

        operator = elementDeque.popOperator();
        assertThat(operator).isInstanceOf(Minus.class);

        operand = elementDeque.popOperand();
        assertThat(operand.getValue()).isEqualTo(4);
    }

    @Test
    @DisplayName("순서에 맞지 않는 입력값 생성자 입력시 IllegalArgumentException 발생여부 테스트")
    public void constructorErrorTest() {
        String input = "1 2 + * 3 - 4";
        String[] split = input.split(" ");

        assertThatThrownBy(() -> {
            ElementDeque elementDeque = new ElementDeque(split);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}