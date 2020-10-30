package humbledude.stringcalculator;

public class Operand implements Token {

    private int value;

    public Operand(int value) {
        this.value = value;
    }

    @Override
    public boolean isOperand() {
        return true;
    }

    @Override
    public Token operation(Token operand1, Token operand2) {
        throw new RuntimeException("저 숫자인데요.. 이거참 나오면 안되는데 ㅎㅎ");
    }

    public int getValue() {
        return this.value;
    }
}
