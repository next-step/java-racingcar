package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorTest {
    @Test
    void plus() {
        Assertions.assertThat(Operator.PLUS.calculate(1, 1)).isEqualTo(2);
    }

    @Test
    void minus() {
        Assertions.assertThat(Operator.MINUS.calculate(1, 1)).isEqualTo(0);
    }

    @Test
    void multiply() {
        Assertions.assertThat(Operator.MULTIPLY.calculate(1, 10)).isEqualTo(10);
    }

    @Test
    void divide() {
        Assertions.assertThat(Operator.DIVIDE.calculate(5, 1)).isEqualTo(5);
    }

    @Test
    void getOperator() {
        Assertions.assertThat(Operator.getOperator("+").calculate(1, 2)).isEqualTo(3);
        Assertions.assertThat(Operator.getOperator("-").calculate(5, 2)).isEqualTo(3);
        Assertions.assertThat(Operator.getOperator("/").calculate(10, 2)).isEqualTo(5);
        Assertions.assertThat(Operator.getOperator("*").calculate(1, 2)).isEqualTo(2);
    }


    @Test
    void contains() {
        Assertions.assertThat(Operator.contains("+")).isTrue();
    }

    @Test
    void testGetOperator() {
        Assertions.assertThatThrownBy(() -> {
            Operator.getOperator("&");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}