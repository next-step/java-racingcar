package stringcalculator.arithmeticcomponent;

/**
 * 1회 연산에 필요한 수식
 * 구성 ( 연산자, 피연산자1, 피연산자2 )
 */
public class ArithmeticExpression {
    private ArithmeticOperator operator;
    private ArithmeticOperand operand1;
    private ArithmeticOperand operand2;

    public ArithmeticExpression(ArithmeticOperand operand1, ArithmeticOperator operator, ArithmeticOperand operand2) {
        if (!isValid(operand1, operator, operand2)) {
            throw new IllegalArgumentException();
        }
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    private boolean isValid(ArithmeticOperand operand1, ArithmeticOperator operator, ArithmeticOperand operand2) {
        return operand1 != null && operator != null && operand2 != null;
    }

    public int result() {
        return operator.function()
                        .apply(operand1.number(), operand2.number());
    }

    public ArithmeticOperator operator() {
        return operator;
    }

    public ArithmeticOperand operand1() {
        return operand1;
    }

    public ArithmeticOperand operand2() {
        return operand2;
    }
}
