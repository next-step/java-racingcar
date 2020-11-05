package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    @DisplayName("더하기")
    public void plus() {
        assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기")
    public void minus() {
        assertThat(Operator.MINUS.calculate(5, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("곱하기")
    public void multiply() {
        assertThat(Operator.MULTIPLY.calculate(1, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("나누기")
    public void divide() {
        assertThat(Operator.DIVIDE.calculate(6, 2)).isEqualTo(3);
    }
}
