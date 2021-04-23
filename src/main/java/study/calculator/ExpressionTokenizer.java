package study.calculator;

import java.util.StringTokenizer;

public final class ExpressionTokenizer {
    String expression;
    StringTokenizer tokenizer;
    Operand leftOperand;

    ExpressionTokenizer(String expression) {
        this.expression = expression;

        if (isValidExpression() == false) {
            throw new IllegalArgumentException();
        }

        tokenizer = new StringTokenizer(expression, " ");

        if (isValidTokenizer() == false) {
            throw new IllegalArgumentException();
        }
    }

    boolean isValidExpression() {
        if (expression == null) {
            return false;
        }

        if (expression.trim() == "") {
            return false;
        }

        return true;
    }

    boolean isValidTokenizer() {
        if (tokenizer.countTokens() % 2 == 0) {
            return false;
        }

        return true;
    }

    public Operand nextToken() {
        if (leftOperand == null) {
            leftOperand = Operand.of(tokenizer.nextToken());
        }
        String operator = tokenizer.nextToken();
        Operand rightOperand = Operand.of(tokenizer.nextToken());

        leftOperand = BiOperator.fromOperatorString(operator).calculate(leftOperand, rightOperand);
        return leftOperand;
    }

    public Boolean hasMoreTokens() {
        return tokenizer.hasMoreTokens();
    }
}
