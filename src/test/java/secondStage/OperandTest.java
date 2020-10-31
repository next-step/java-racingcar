package secondStage;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {

    @DisplayName(value = "피연산자 추출 시 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + d - 2", "1 + 2 + ! - 2", "@ + 2 - 2"})
    void parseIntNumberFormException(String str) {
        // given
        String[] source = str.split(" ");

        // when
        assertThatThrownBy(() -> {
            new Operand(source);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙 연산자가 아닙니다.");
    }
}