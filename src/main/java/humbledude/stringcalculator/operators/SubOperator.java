package humbledude.stringcalculator.operators;

import humbledude.stringcalculator.Operand;
import humbledude.stringcalculator.Token;

public class SubOperator implements Token {

    @Override
    public boolean isOperand() {
        return false;
    }

    @Override
    public Token operation(Token operand1, Token operand2) {
        int result = operand1.getValue() - operand2.getValue();
        return new Operand(result);
    }

    @Override
    public int getValue() {
        throw new RuntimeException("저 연산자인데요.. 이거 나오면 안되는데..");
    }
}
