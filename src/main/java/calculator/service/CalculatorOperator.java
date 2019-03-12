package calculator.service;

public enum CalculatorOperator {
    ADD("+", (v1, v2) -> v1 + v2),
    SUBTRACT("-", (v1, v2) -> v1 - v2),
    MULTIPLICATION("*", (v1, v2) -> v1 * v2),
    DIVISION("/", (v1, v2) -> v1 / v2);

    private String operator;

    private CalculateFunction expression;

    CalculatorOperator(String operator, CalculateFunction expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public Integer calculate(Integer v1, Integer v2) {
        return expression.calculate(v1, v2);
    }

    public String getOperator() {
        return operator;
    }
}
