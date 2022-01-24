package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    public void 덧셈기호를_넣으면_PLUS_반환() {
        //given
        String plus = "+";

        //when
        Optional<Operator> optional = Operator.fromString(plus);

        //then
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get().name()).isEqualTo("PLUS");
    }

    @Test
    public void 뺄셈기호를_넣으면_MINUS_반환() {
        //given
        String minus = "-";

        //when
        Optional<Operator> optional = Operator.fromString(minus);

        //then
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get().name()).isEqualTo("MINUS");
    }

    @Test
    public void 곱셈기호를_넣으면_MULTIPLY_반환() {
        //given
        String multiply = "*";

        //when
        Optional<Operator> optional = Operator.fromString(multiply);

        //then
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get().name()).isEqualTo("MULTIPLY");
    }

    @Test
    public void 나눗셈기호를_넣으면_DIVIDE_반환() {
        //given
        String divide = "/";

        //when
        Optional<Operator> optional = Operator.fromString(divide);

        //then
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get().name()).isEqualTo("DIVIDE");
    }
}