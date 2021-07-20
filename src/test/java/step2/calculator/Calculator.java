package step2.calculator;

import org.junit.platform.commons.util.StringUtils;
import step2.calculator.exceptions.EmptyExpressionException;
import step2.calculator.exceptions.InvalidExpressionException;

import java.util.StringTokenizer;

public class Calculator {
    private final int MINIMUM_SIZE = 2;

    public int calculate(String text) {
        if (StringUtils.isBlank(text)) throw new EmptyExpressionException();

        StringTokenizer tokens = new StringTokenizer(text);

        if (!isAbleToCalculateFirst(tokens)) throw new InvalidExpressionException();

        int result = calculate(tokens);

        if (!tokens.hasMoreTokens()) return result;
        return calculateNextLoop(result, tokens);
    }

    private int calculate(StringTokenizer tokens) {
        return ExpressionWith.of(getNumber(tokens.nextToken()), getExpression(tokens.nextToken()), getNumber(tokens.nextToken())).calculate();
    }

    private int calculate(int resultTemp, StringTokenizer tokens) {
        return ExpressionWith.of(resultTemp, getExpression(tokens.nextToken()), getNumber(tokens.nextToken())).calculate();
    }

    private int calculateNextLoop(int resultTemp, StringTokenizer tokens) {
        if (!isAbleToCalculateNext(tokens)) throw new InvalidExpressionException();

        while (tokens.hasMoreTokens()) resultTemp = calculate(resultTemp, tokens);
        return resultTemp;
    }

    private int getNumber(String number) throws InvalidExpressionException {
        return Integer.parseInt(number);
    }

    private Expression getExpression(String expression) {
        return Expression.of(expression);
    }

    private boolean isAbleToCalculateFirst(StringTokenizer tokens) {
        return tokens.countTokens() > MINIMUM_SIZE;
    }

    private boolean isAbleToCalculateNext(StringTokenizer tokens) {
        return tokens.countTokens() % MINIMUM_SIZE == 0;
    }
}
