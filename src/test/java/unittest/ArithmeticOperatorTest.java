package unittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticOperatorTest {

    static ArithmeticOperator operator;

    @BeforeAll
    public static void set() {
        operator = new ArithmeticOperator();
    }

    @DisplayName("calculateAAndB TEST")
    @Test
    public void calculateAAndBTest() {
        assertThat(operator.calculateAAndB(1,3,operator.ADD_OPERATOR)).isEqualTo(4);
        assertThat(operator.calculateAAndB(3,3,operator.MULTIPLY_OPERATOR)).isEqualTo(9);
        assertThat(operator.calculateAAndB(4,3,operator.DIVIDE_OPERATOR)).isEqualTo(1);
        assertThat(operator.calculateAAndB(4,3,operator.SUBSTRACT_OPERATOR)).isEqualTo(1);
    }
}

