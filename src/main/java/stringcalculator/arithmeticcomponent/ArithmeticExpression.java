package stringcalculator.arithmeticcomponent;

/**
 * 1회 연산에 필요한 수식
 * 구성 ( 연산자, 피연산자1, 피연산자2 )
 */
public class ArithmeticExpression {
    private final ArithmeticOperand firstOperand;
    private final ArithmeticOperator operator;
    private final ArithmeticOperand secondOperand;

    public ArithmeticExpression(ArithmeticOperand firstOperand, ArithmeticOperator operator, ArithmeticOperand secondOperand) {
        if (!isValid(firstOperand, operator, secondOperand)) {
            throw new IllegalArgumentException();
        }
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
    }

    private boolean isValid(ArithmeticOperand firstOperand, ArithmeticOperator operator, ArithmeticOperand secondOperand) {
        return firstOperand != null && operator != null && secondOperand != null;
    }

    public int result() {
        return operator.function()
                        .apply(firstOperand.number(), secondOperand.number());
    }

    public ArithmeticOperator operator() {
        return operator;
    }

    public ArithmeticOperand firstOperand() {
        return firstOperand;
    }

    public ArithmeticOperand secondOperand() {
        return secondOperand;
    }
}
