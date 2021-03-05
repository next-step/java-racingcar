package operator;

public class MinusOperator implements Operator {

    @Override
    public int operate(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }
}
