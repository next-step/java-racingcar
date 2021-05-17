package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    void 더하기() {
        Operator operator = new Operator();
        int result = operator.plus(3, 5);
        assertThat(result).isEqualTo(8);

        int result2 = operator.plus(-9, 5);
        assertThat(result2).isEqualTo(-4);
    }

    @Test
    void 빼기() {
        Operator operator = new Operator();
        int result = operator.minus(9, 8);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱하기() {
        Operator operator = new Operator();
        int result = operator.multiply(9, 8);
        assertThat(result).isEqualTo(72);
    }

    @Test
    void 나누기() {
        Operator operator = new Operator();
        int result = operator.divide(9, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 나누기_실패() {
        Operator operator = new Operator();
        assertThatIllegalArgumentException().isThrownBy(
                () -> operator.divide(9, 0)
        );
    }
}