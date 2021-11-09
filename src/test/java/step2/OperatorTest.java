package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperatorTest {

    private final Operand first = new Operand(6);
    private final Operand second = new Operand(2);

    @ParameterizedTest
    @CsvSource(value = {"+:8", "-:4", "*:12", "/:3"}, delimiter = ':')
    void operationTest(String operator, Operand ans) {
        assertEquals(ans, Operator.getOperator(operator).operate(first, second));
    }
}
