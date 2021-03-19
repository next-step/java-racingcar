package operator;

public class MultiplicationOperator implements Operator {

    @Override
    public int operate(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

}
