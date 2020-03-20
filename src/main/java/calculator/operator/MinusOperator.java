package calculator.operator;

public class MinusOperator extends Operator {

    @Override
    public double calculate(double beforeNum, double afterNum) {
        return beforeNum - afterNum;
    }
}
