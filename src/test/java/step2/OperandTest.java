package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OperandTest {

    private final Operand first = new Operand(6);
    private final Operand second = new Operand(2);

    @Test
    void operand() {
        Operand operand = new Operand("1");
        Operand operand2 = new Operand(1);
        Operand operand3 = new Operand(new Operand(1));
    }

    @Test
    void plus() {
        assertEquals(new Operand(8), first.plus(second));
    }

    @Test
    void minus() {
        assertEquals(new Operand(4), first.minus(second));
    }

    @Test
    void multiply() {
        assertEquals(new Operand(12), first.multiply(second));
    }

    @Test
    void divide() {
        assertEquals(new Operand(3), first.divide(second));
    }
}
