package calculator;

import calculator.enums.Operator;
import calculator.utils.ExpressionValidator;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {

    private static final String DELIMITER = " ";
    private final String[] expression;
    private final Queue<Integer> operands = new LinkedList<>();
    private final Queue<Operator> operators = new LinkedList<>();

    public Expression(String expression) {
        this.expression = expression.split(DELIMITER);
        ExpressionValidator.validateNull(this.expression);
        ExpressionValidator.validateEmpty(this.expression);
        ExpressionValidator.validateMinimumLength(this.expression);
        ExpressionValidator.validateOddLength(this.expression);
        extractOperands();
        extractOperators();
    }

    public Queue<Integer> getOperands() {
        return operands;
    }

    public Queue<Operator> getOperators() {
        return operators;
    }

    private void extractOperators() {
        for (int i = 0; i < expression.length; i += 2) {
            operands.add(ExpressionValidator.validateInteger(expression[i]));
        }
    }

    private void extractOperands() {
        for (int i = 1; i < expression.length; i += 2) {
            operators.add(Operator.findBySymbol(expression[i]));
        }
    }
}
