package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    public void from() {
        Operator operator = Operator.from("+");
        assertThat(operator).isEqualTo(Operator.PLUS);
    }

    @Test
    @DisplayName("0으로 나누면 익셉션 던진다")
    public void divide_with_0_throw_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Operator.DIVIDE.operate(1, 0)
        );
    }

}
