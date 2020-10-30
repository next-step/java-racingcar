package humbledude.stringcalculator.operators;

import humbledude.stringcalculator.Operand;
import humbledude.stringcalculator.Token;

public class SubOperator implements Token {

    @Override
    public Token operation(Token operand1, Token operand2) {
        int result = operand1.getValue() - operand2.getValue();
        return new Operand(result);
    }
}
