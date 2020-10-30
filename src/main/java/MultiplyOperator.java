public class MultiplyOperator implements Token {

    @Override
    public boolean isOperand() {
        return false;
    }

    @Override
    public Token operation(Token operand1, Token operand2) {
        int result = operand1.getValue() * operand2.getValue();
        return new Operand(result);
    }

    @Override
    public int getValue() {
        throw new RuntimeException("이거 나오면 안되는데..");
    }
}
