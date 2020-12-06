package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    @DisplayName("덧셈")
    public void plus() {
        assertThat(Operator.PLUS.apply(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        assertThat(Operator.MINUS.apply(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        assertThat(Operator.MULTIPLY.apply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        assertThat(Operator.DIVIDE.apply(2, 1)).isEqualTo(2);
    }
}
