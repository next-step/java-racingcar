package calculator.operator;

public class MultiplyOperator extends Operator {

    @Override
    public double calculate(double beforeNum, double afterNum) {
        double result = beforeNum * afterNum;
        return Math.round(result * 100) / 100.0;
    }
}
