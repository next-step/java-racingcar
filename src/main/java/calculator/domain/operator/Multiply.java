package calculator.domain.operator;

public class Multiply implements Operator {

    public Multiply() {}

    @Override
    public int calculate(int total, int operand) {
        return total * operand;
    }
}
