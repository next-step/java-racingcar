package stringcalculator.domain;

import stringcalculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @Test
    void add() {
        int result = Operator.from("+").operate(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void sub() {
        int result = Operator.from("-").operate(7, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void div() {
        int result = Operator.from("/").operate(9, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void mul() {
        int result = Operator.from("*").operate(1, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.from("=").operate(1, 3));
    }

}
