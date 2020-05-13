package com.cheolhyeonpark.step2;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    ExpressionParser expressionParser;

    public StringCalculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public int calculate(String input) {
        validateInput(input);
        return calculate(expressionParser.getExpressionFromString(input));
    }

    public int calculate(Expression expression) {
        return expression.calculate();
    }

    private void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("There is no input. Please check your input data.");
        }
    }
}
