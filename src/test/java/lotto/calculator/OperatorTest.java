package lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void valueOf() {
        assertThat(Operator.of("+")).isEqualTo(Operator.ADD);
        assertThat(Operator.of("-")).isEqualTo(Operator.SUBTRACT);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

    @DisplayName("사칙연산이 아닌 경우 예외 발생")
    @Test
    void operator_exception() {
        assertThatThrownBy(() -> Operator.of("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다");
    }
}