package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    public void addtion() {
        Assertions.assertThat(Operator.valueOf("ADDTION").calculate(1,4)).isEqualTo(5);
    }

    @Test
    public void subtract() {
        Assertions.assertThat(Operator.valueOf("SUBTRACT").calculate(10,4)).isEqualTo(6);
    }

    @Test
    public void division() {
        Assertions.assertThat(Operator.valueOf("DIVISION").calculate(8,4)).isEqualTo(2);
    }

    @Test
    public void multiplication() {
        Assertions.assertThat(Operator.valueOf("MULTIPLICATION").calculate(10,4)).isEqualTo(40);
    }
}
