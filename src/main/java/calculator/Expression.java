package calculator;

/**
 * 수식
 */
public class Expression {
    private final Number operand1;
    private final String operator;
    private final Number operand2;

    private Expression(Number operand1, String operator, Number operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public static Expression create(Number operand1, String operator, Number operand2) {
        return new Expression(operand1, operator, operand2);
    }

    public Number calculate() {
        return Operator.calculate(operator, operand1, operand2);
    }
}
