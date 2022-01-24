package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class OperatorsTest {

    final String NOT_OPERATIONS_MESSAGE = "연산기호가 아닙니다.";

    @Test
    public void 연산기호를_넣는건_정상동작() {
        //given
        Operators operators = Operators.get();

        //when
        String plus = "+";
        String minus = "-";
        String multiply = "*";
        String divide = "/";

        //then
        assertThatCode(() -> operators.addOperator(plus)).doesNotThrowAnyException();
        assertThatCode(() -> operators.addOperator(minus)).doesNotThrowAnyException();
        assertThatCode(() -> operators.addOperator(multiply)).doesNotThrowAnyException();
        assertThatCode(() -> operators.addOperator(divide)).doesNotThrowAnyException();
    }

    @Test
    public void 연산기호이외의_값이_들어가면_예외발생() {
        //given
        Operators operators = Operators.get();

        //when
        String input1 = "++";
        String input2 = "123";

        //then
        assertThatCode(() -> operators.addOperator(input1)).hasMessageContaining(NOT_OPERATIONS_MESSAGE);
        assertThatCode(() -> operators.addOperator(input2)).hasMessageContaining(NOT_OPERATIONS_MESSAGE);
    }
}