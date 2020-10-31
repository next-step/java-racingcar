package step2;

public class SingleExpressionCalculator {

    public int calc(SingleExpression expression) {
        int firstFactor = expression.getOperand1().getValue();
        int secondFactor = expression.getOperand2().getValue();
        switch (expression.getOperator().getValue()) {
            case '+':
                return add(firstFactor, secondFactor);
            case '-':
                return minus(firstFactor, secondFactor);
            case '/':
                return divide(firstFactor, secondFactor);
            case '*':
                return multiply(firstFactor, secondFactor);
            default:
                return -1;
        }
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int minus(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        return first / second;
    }

}
