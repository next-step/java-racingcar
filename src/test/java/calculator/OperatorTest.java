package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperatorTest {

    @Test
    public void plus() {
        assertThat(Operator.calculate(3, 2, "+")).isEqualTo(5);
    }

    @Test
    public void minus() {
        assertThat(Operator.calculate(3, 2, "-")).isEqualTo(1);
    }

    @Test
    public void multiply() {
        assertThat(Operator.calculate(3, 2, "*")).isEqualTo(6);
    }

    @Test
    public void divide() {
        assertThat(Operator.calculate(4, 2, "/")).isEqualTo(2);
    }

}
