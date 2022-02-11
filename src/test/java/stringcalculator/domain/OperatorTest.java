package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void add() {
        int result = Operator.of("+").operate(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void sub() {
        int result = Operator.of("-").operate(7, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void div() {
        int result = Operator.of("/").operate(9, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void mul() {
        int result = Operator.of("*").operate(1, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void exception() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Operator.of("=").operate(1, 3));
    }

}