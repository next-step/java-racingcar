package operator;

public class MultiplyOperator implements Operator {
    @Override
    public int calculate(double leftHand, double rightHand) {
        return (int) (leftHand * rightHand);
    }
}
