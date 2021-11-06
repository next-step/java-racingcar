package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void 덧셈() {
        //given
        Operator operator = Operator.of("+");
        //when
        int result = operator.calculate(Number.of("1"), Number.of("2"));
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        //given
        Operator operator = Operator.of("-");
        //when
        int result = operator.calculate(Number.of("1"), Number.of("2"));
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        //given
        Operator operator = Operator.of("*");
        //when
        int result = operator.calculate(Number.of("1"), Number.of("2"));
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        //given
        Operator operator = Operator.of("/");
        //when
        int result = operator.calculate(Number.of("1"), Number.of("2"));
        //then
        assertThat(result).isEqualTo(0);
    }
}
