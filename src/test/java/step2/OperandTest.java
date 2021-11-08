package step2;

import org.junit.jupiter.api.Test;

public class OperandTest {

    @Test
    void operand() {
        Operand operand = new Operand("1");
        Operand operand2 = new Operand(1);
        Operand operand3 = new Operand(new Operand(1));
    }
}
