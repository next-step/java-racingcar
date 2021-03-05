package operator;

public class DivisionOperator implements Operator {

    @Override
    public int operate(int firstValue, int secondValue) {
        if(isZero(secondValue)) throw new IllegalArgumentException();
        return firstValue / secondValue;
    }

    private boolean isZero(int value){
        return value == 0 ? true : false;
    }

}
