package stringcalculator.arithmeticcomponent;

/**
 * 연산에 필요한 피연산자
 */
public class ArithmeticOperand {
    private int number;

    public ArithmeticOperand(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
