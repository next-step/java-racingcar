package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 Operands 테스트")
class OperandsTest {
    @Test
    void Operand는_빈_컬렉션으로_생성_할_경우_런타임_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Operands(List.of());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sum은_operands의_합계를_반환한다() {
        Operands operands = new Operands(List.of(new Operand(1), new Operand(2)));

        assertThat(operands.sum()).isEqualTo(3);
    }
}
