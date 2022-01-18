package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class OperandTest {

    @Test
    void Operand_생성_테스트() {
        Operand operand = new Operand("1");
        assertThat(operand.getNumber()).isEqualTo(1);
    }

    @Test
    void Operand_예외_테스트() {
        assertThatThrownBy(() -> new Operand("r"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Operand("r"))
            .hasMessageContaining("[ERROR]");
    }
}