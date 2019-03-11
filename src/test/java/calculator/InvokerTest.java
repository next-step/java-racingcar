package calculator;

import calculator.operation.Operation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvokerTest {

    @Test
    public void add() {
        Operation operation = Invoker.getOperation("+");
        int result = operation.calculate( 1, 2 );

        assertEquals( 3, result );
    }

    @Test
    public void subtract() {
        Operation operation = Invoker.getOperation("-");
        int result = operation.calculate( 3,  1 );

        assertEquals( 2, result );
    }

    @Test
    public void multiply() {
        Operation operation = Invoker.getOperation("*");
        int result = operation.calculate( 2,  5 );

        assertEquals( 10, result );
    }

    @Test
    public void divide() {
        Operation operation = Invoker.getOperation("/");
        int result = operation.calculate( 20,  4 );

        assertEquals( 5, result );
    }
}