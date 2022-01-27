package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    public void 덧셈기호를_넣으면_PLUS_반환() {
        //given
        String plus = "+";

        //when
        Operator operator = Operator.fromString(plus);

        //then
        assertThat(operator.name()).isEqualTo("PLUS");
    }

    @Test
    public void 뺄셈기호를_넣으면_MINUS_반환() {
        //given
        String minus = "-";

        //when
        Operator operator = Operator.fromString(minus);

        //then
        assertThat(operator.name()).isEqualTo("MINUS");
    }

    @Test
    public void 곱셈기호를_넣으면_MULTIPLY_반환() {
        //given
        String multiply = "*";

        //when
        Operator operator = Operator.fromString(multiply);

        //then
        assertThat(operator.name()).isEqualTo("MULTIPLY");
    }

    @Test
    public void 나눗셈기호를_넣으면_DIVIDE_반환() {
        //given
        String divide = "/";

        //when
        Operator operator = Operator.fromString(divide);

        //then
        assertThat(operator.name()).isEqualTo("DIVIDE");
    }
}