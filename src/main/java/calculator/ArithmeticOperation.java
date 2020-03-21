package calculator;

import java.util.function.BiFunction;

public enum ArithmeticOperation {

    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> operand1 / operand2);

    private String expression;
    private BiFunction<Double, Double, Double> calculate;

    ArithmeticOperation(String expression, BiFunction<Double, Double, Double> calculate) {
        this.expression = expression;
        this.calculate = calculate;
    }

    public Double calculate(Double operand1, Double operand2) {
        return calculate.apply(operand1, operand2);
    }

    public boolean isEqusls(String val) {
        return this.expression.equals(val);
    }

    public static ArithmeticOperation findMatchedExpression(String operator) {
        for (ArithmeticOperation valus : ArithmeticOperation.values()) {
            if (valus.isEqusls(operator)) {
                return valus;
            }
        }
        throw new IllegalArgumentException("올바른 연산자가 아닙니다");
    }

    public static Double calculateInput(Double operand1, Double operand2, String operator) {
        return findMatchedExpression(operator).calculate(operand1, operand2);
    }

    public String getExpression() {
        return expression;
    }
}
