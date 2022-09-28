package lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("연산")
    @ParameterizedTest
    @CsvSource(value = {
            "ADD,8,2,10",
            "SUBTRACT,8,2,6",
            "MULTIPLY,8,2,16",
            "DIVIDE,8,2,4"
    })
    void operate(Operator operator, String left, String right, String expected) {
        assertThat(operator.operate(new Number(left), new Number(right))).isEqualTo(new Number(expected));
    }
}