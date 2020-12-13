package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void add() {
        assertThat(Operator.ADD.calculate(8, 5)).isEqualTo(13);
    }

    @Test
    void subtract() {
        assertThat(Operator.SUBTRACT.calculate(8, 5)).isEqualTo(3);
    }

    @Test
    void multiply() {
        assertThat(Operator.MULTIPLY.calculate(8, 5)).isEqualTo(40);
    }

    @Test
    void division() {
        assertThat(Operator.DIVISION.calculate(8, 5)).isEqualTo(1);
    }
}
