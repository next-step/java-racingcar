package calculator.domain.operator;

public class Minus implements Operator {

    public Minus() {
    }

    @Override
    public int calculate(int total, int operand) {
        return total - operand;
    }
}
