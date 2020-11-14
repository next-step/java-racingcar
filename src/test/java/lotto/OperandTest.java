package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {

    @DisplayName("Operand 음수 생성 실패 테스트")
    @Test
    public void test1() {
        assertThatThrownBy(
                () -> {
                    Operand operand = new Operand("-1");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
