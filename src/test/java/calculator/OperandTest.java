package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 Operand 테스트")
class OperandTest {

    @Test
    void Operand는_음수로_생설_할_경우_런타임_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Operand("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Operand는_숫자가_아닌_문자열로_생설_할_경우_런타임_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new Operand("abc");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void add는_입력받은_피연산자와_합계를_가진_새_피연산자를_반환한다() {
        Operand one = new Operand(1);
        Operand two = new Operand(2);
        Operand three = new Operand(3);

        assertThat(one.add(two)).isEqualTo(three);
    }
}
