package operator;

public class MinusOperator implements Operator {
    @Override
    public int calculate(double leftHand, double rightHand) {
        return (int) (leftHand - rightHand);
    }
}
