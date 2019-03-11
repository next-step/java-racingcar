package calculator;

import calculator.operation.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InvokerTest {

    @Test
    public void add() {
        Operation operation = Invoker.getOperation("+");
        int result = operation.calculate( 1, 2 );

        assertThat( operation, instanceOf(Add.class) );
        assertEquals( 3, result );
    }

    @Test
    public void subtract() {
        Operation operation = Invoker.getOperation("-");
        int result = operation.calculate( 3,  1 );

        assertThat( operation, instanceOf(Subtract.class) );
        assertEquals( 2, result );
    }

    @Test
    public void multiply() {
        Operation operation = Invoker.getOperation("*");
        int result = operation.calculate( 2,  5 );

        assertThat( operation, instanceOf(Multiply.class) );
        assertEquals( 10, result );
    }

    @Test
    public void divide() {
        Operation operation = Invoker.getOperation("/");
        int result = operation.calculate( 20,  4 );

        assertThat( operation, instanceOf(Divide.class) );
        assertEquals( 5, result );
    }
}