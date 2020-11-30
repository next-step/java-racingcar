package lotto.stringsumcalculator;

import lotto.stringsumcalculator.model.Operand;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;


public class OperandTest {

    @Test
    @DisplayName("피연산자 생성이 잘 되는가")
    public void createOperand(){
        Operand operand = new Operand(1);
        assertEquals(operand.getValue(),1);
    }
}
