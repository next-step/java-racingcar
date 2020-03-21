package calculator.operator;

public class PlusOperator extends Operator {

    @Override
    public double calculate(double beforeNum, double afterNum) {
        return beforeNum + afterNum;
    }
}
