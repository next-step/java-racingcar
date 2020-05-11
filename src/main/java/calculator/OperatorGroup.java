package calculator;

public enum OperatorGroup {

    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private String operator;

    OperatorGroup(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public float calculate(float operand1, float operand2) {
        Calculator calculator = getCalculator(operator);
        return calculator.calculate(operand1, operand2);
    }

    private Calculator getCalculator(String operator) {
        switch (valueOf(operator)) {
            case PLUS:
                return new PlusCalculator();
            case MINUS:
                return new MinusCalculator();
            case DIVIDE:
                return new DivideCalculator();
            case MULTIPLY:
                return new MultiplyCalculator();
            default:
                throw new IllegalArgumentException();
        }
    }
}
