package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperandTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10000000000000000"})
    @DisplayName("from 메서드에 0이상의 숫자 형태의 문자열을 넣으면 정상적으로 Operand 객체를 생성한다.")
    void from_PositiveOrZeroNumericToken_Operand(final String token) {
        final Operand operand = Operand.from(token);

        assertThat(operand.value())
                .isEqualTo(new BigInteger(token));
    }

    @Test
    @DisplayName("from 메서드에 숫자 형태가 아닌 문자열을 넣으면 RuntimeException을 던진다.")
    void from_NonNumericToken_RuntimeException() {
        assertThatThrownBy(() -> Operand.from("a"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("수식을 이루는 피연산자는 반드시 숫자이어야 합니다.");
    }

    @Test
    @DisplayName("from 메서드에 음수 형태의 문자열을 넣으면 RuntimeException을 던진다.")
    void from_NegativeToken_RuntimeException() {
        assertThatThrownBy(() -> Operand.from("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("피연산자는 반드시 0 이상이어야 합니다.");
    }
}
