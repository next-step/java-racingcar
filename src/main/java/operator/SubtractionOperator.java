package operator;

import java.util.Objects;

public class SubtractionOperator implements Operator {
    @Override
    public boolean isTarget(String input) {
        return Objects.equals("-", input);
    }

    @Override
    public int calculate(int leftHand, int rightHand) {
        return leftHand - rightHand;
    }
}
