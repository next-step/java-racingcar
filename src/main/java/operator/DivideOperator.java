package operator;

public class DivideOperator implements Operator {

    @Override
    public int calculate(double leftHand, double rightHand) {
        return (int) (leftHand / rightHand);
    }
}
