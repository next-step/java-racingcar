package com.jaenyeong.mission01.stringcalculator;

public class StringCalculator {
    private static final String ERR_OPERATION = "error occurred during operation";
    private static final int OPERATOR_SIZE_MIN = 1;
    private static final int OPERAND_SIZE_MIN = 2;
    private final StringParser parser;

    public StringCalculator() {
        this.parser = new StringParser();
    }

    public int calculate(final String strExp) {
        final Expression expression = this.parser.parseExpression(strExp);
        if (checkInvalidSize(expression)) {
            throw new IllegalArgumentException("operator or operand is not valid");
        }

        return calculateExpression(expression);
    }

    private boolean checkInvalidSize(final Expression expression) {
        return (expression.getOperators().size() < OPERATOR_SIZE_MIN)
            || (expression.getOperands().size() < OPERAND_SIZE_MIN)
            || ((expression.getOperators().size() + 1) != expression.getOperands().size());
    }

    public int calculateExpression(final Expression expression) {
        try {
            return calculate(expression);
        } catch (Exception e) {
            throw new ArithmeticException(ERR_OPERATION);
        }
    }

    private int calculate(final Expression expression) {
        int calculationResult = expression.getOperands().get(0);

        for (int i = 0; i < expression.getOperators().size(); i++) {
            final Operator operator = expression.getOperators().get(i);
            final int operand = expression.getOperands().get(i + 1);

            calculationResult = elementCalculate(operator, calculationResult, operand);
        }

        return calculationResult;
    }

    private int elementCalculate(final Operator operator, final int firstOp, final int secondOp) {
        return Operator.calculate(operator, firstOp, secondOp);
    }
}
