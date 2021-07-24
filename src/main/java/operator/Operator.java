package operator;

public interface Operator {

    boolean isTarget(String input);
    int calculate(int leftHand, int rightHand);
}
