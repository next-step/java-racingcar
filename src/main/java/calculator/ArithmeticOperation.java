package calculator;

public enum ArithmeticOperation {

    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String expression;

    ArithmeticOperation(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public boolean isEqusls(String val) {
        return this.expression.equals(val);
    }
}
