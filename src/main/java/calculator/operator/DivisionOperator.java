package calculator.operator;

public class DivisionOperator extends Operator {

    // 소수점 둘째 자리까지
    @Override
    public double calculate(double operand1, double operand2) {
        double result = operand1 / operand2;
        return Math.round(result * 100) / 100.0;
    }
}
