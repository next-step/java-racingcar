package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @Test
    void plus() {
        Operator operator = Operator.of("+");
        MyNumber actual = operator.operate(1, 2);
        assertThat(actual).isEqualTo(new MyNumber(3));
    }

    @Test
    void minus() {
        Operator operator = Operator.of("-");
        MyNumber actual = operator.operate(4, 3);
        assertThat(actual).isEqualTo(new MyNumber(1));
    }

    @Test
    void times() {
        Operator operator = Operator.of("*");
        MyNumber actual = operator.operate(4, 3);
        assertThat(actual).isEqualTo(new MyNumber(12));
    }

    @Test
    void divideBy() {
        Operator operator = Operator.of("/");
        MyNumber actual = operator.operate(4, 2);
        assertThat(actual).isEqualTo(new MyNumber(2));
    }

    @Test
    void invalid_operator() {
        assertThatThrownBy(() -> {
            Operator.of("@");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
