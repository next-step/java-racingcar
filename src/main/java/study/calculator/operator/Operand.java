package study.calculator.operator;

public class Operand {

    int value;

    public Operand(int value) {
        this.value = value;
    }

    public static Operand toOperand(String integerExp) {
        return new Operand(Integer.parseInt(integerExp));
    }

    public int getValue() {
        return value;
    }


}
