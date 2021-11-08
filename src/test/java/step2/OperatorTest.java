package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    void plusSuccess() {
        assertEquals(Operator.getOperator("+").calculate(1, 2), 3);
    }

    @Test
    void minusSuccess() {
        assertEquals(Operator.getOperator("-").calculate(2, 1), 1);
    }

    @Test
    void multiplySuccess() {
        assertEquals(Operator.getOperator("*").calculate(2, 3), 6);
    }

    @Test
    void divideSuccess() {
        assertEquals(Operator.getOperator("/").calculate(6, 3), 2);
    }
}
