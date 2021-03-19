package operator;

public class PlusOperator implements Operator {

    @Override
    public int operate(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

}
