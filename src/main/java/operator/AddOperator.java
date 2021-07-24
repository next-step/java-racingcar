package operator;

public class AddOperator implements Operator {
    @Override
    public int calculate(double leftHand, double rightHand) {
        return (int) (leftHand + rightHand);
    }
}
