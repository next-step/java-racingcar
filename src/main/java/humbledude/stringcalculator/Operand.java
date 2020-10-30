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

    public int getValue() {
        return this.value;
    }
}
