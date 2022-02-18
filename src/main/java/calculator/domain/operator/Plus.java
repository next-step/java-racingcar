package calculator.domain.operator;

public class Plus implements Operator {

    public Plus() {
    }

    @Override
    public int calculate(int total, int operand) {
        return total + operand;
    }
}
