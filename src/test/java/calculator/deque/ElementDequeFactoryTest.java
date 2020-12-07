package calculator.deque;

import calculator.element.operand.Operand;
import calculator.element.operaor.Add;
import calculator.element.operaor.Minus;
import calculator.element.operaor.Multiply;
import calculator.element.operaor.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ElementDequeFactoryTest {

    @Test
    @DisplayName("정상적인 수식 입력시 파싱후 ElementDeque 생성하는지 테스트")
    public void createElementDequeTest() {
        String input = "1 + 2 * 3 - 4";
        ElementDeque elementDeque = ElementDequeFactory.createElementDeque(input);

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
    @DisplayName("순서에 맞지 않는 수식 입력시 IllegalArgumentException 발생여부 테스트")
    public void createElementDequeErrorTest() {
        String input = "1 2 + * 3 - 4";

        assertThatThrownBy(() -> {
            ElementDequeFactory.createElementDeque(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}