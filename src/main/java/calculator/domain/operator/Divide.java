package calculator.domain.operator;

public class Divide implements Operator {

    public Divide() {}

    @Override
    public int calculate(int total, int operand) {
        if (operand == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return total / operand;
    }
}
