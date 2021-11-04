package study02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    @DisplayName("Bifunction 계산확인")
    void compute() {
        assertThat(Operator.ADDITION.operate(new CustomNumber(1),new CustomNumber(2)).getNumber()).isEqualTo(3);
        assertThat(Operator.SUBTRACTION.operate(new CustomNumber(5),new CustomNumber(4)).getNumber()).isEqualTo(1);
        assertThat(Operator.DIVISION.operate(new CustomNumber(9),new CustomNumber(3)).getNumber()).isEqualTo(3);
        assertThat(Operator.MULTIPLICATION.operate(new CustomNumber(10),new CustomNumber(2)).getNumber()).isEqualTo(20);
    }

    @Test
    @DisplayName("유효하지 않은 수식기호")
    void invalidOperator() {
        assertThatThrownBy(() -> {
            Operator.of("%");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}