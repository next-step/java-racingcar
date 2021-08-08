package stage2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OperationTest {

    private Operation operation;

    @Test
    void operateAddTest() {
        operation = Operation.ADD;
        final int result = operation.operate(1, 2);
        final int expectedValue = 3;
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void operateMinusTest() {
        operation = Operation.MINUS;
        final int result = operation.operate(1, 2);
        final int expectedValue = -1;
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void operateMultiTest() {
        operation = Operation.MULTI;
        final int result = operation.operate(1, 2);
        final int expectedValue = 2;
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void operateDivideTest() {
        operation = Operation.DIVIDE;
        final int result = operation.operate(2, 2);
        final int expectedValue = 1;
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    @DisplayName("올바른 연산자 테스트")
    void findOperationTest() {
        String inputOperation = "+";
        final Operation resultOperation = Operation.findOperation(inputOperation);
        assertThat(resultOperation).isEqualTo(Operation.ADD);
    }

    @Test
    @DisplayName("잘못된 연산자 테스트")
    void findOperationInvalidTest() {
        String inputOperation = "?";
        final Throwable throwable = catchThrowable(() -> Operation.findOperation(inputOperation));
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
