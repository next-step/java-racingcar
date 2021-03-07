package calculator;

import calculator.enums.Operator;
import calculator.utils.ExpressionValidator;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private static final String DELIMITER = " ";
    private final String[] expression;
    private final List<Integer> operands = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Expression(String expression) {
        this.expression = expression.split(DELIMITER);
        ExpressionValidator.validateNull(this.expression);
        ExpressionValidator.validateEmpty(this.expression);
        ExpressionValidator.validateMinimumLength(this.expression);
        ExpressionValidator.validateOddLength(this.expression);
        extractOperands();
        extractOperators();
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<Operator> getOperators() {
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
