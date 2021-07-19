package step2.calculator;

import org.junit.platform.commons.util.StringUtils;

import java.util.StringTokenizer;

public class Calculator {

    public int calculate(String text) {
        if (StringUtils.isBlank(text)) throw new IllegalArgumentException("잘못된 수식입니다. : 비어있거나 null");

        StringTokenizer tokens = new StringTokenizer(text);

        if (!isAbleToCalculateFirst(tokens)) throw new IllegalArgumentException("잘못된 수식입니다. : 수식 요건 불충족");

        int result = calculate(tokens);

        if (!tokens.hasMoreTokens()) return result;

        if (!isAbleToCalculateNext(tokens)) throw new IllegalArgumentException("잘못된 수식입니다. : 수식 요건 불충족");

        while (tokens.hasMoreTokens()) result = calculate(result, tokens);

        return result;
    }

    private int calculate(StringTokenizer tokens) {
        return ExpressionWith.of(getNumber(tokens.nextToken()), getExpression(tokens.nextToken()), getNumber(tokens.nextToken())).calculate();
    }

    private int calculate(int resultTemp, StringTokenizer tokens) {
        return ExpressionWith.of(resultTemp, getExpression(tokens.nextToken()), getNumber(tokens.nextToken())).calculate();
    }

    private int getNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 수식입니다. : 숫자 파싱 오류");
        }
    }

    private Expression getExpression(String expression) {
        return Expression.of(expression);
    }

    private boolean isAbleToCalculateFirst(StringTokenizer tokens) {
        return tokens.countTokens() > 2;
    }

    private boolean isAbleToCalculateNext(StringTokenizer tokens) {
        return tokens.countTokens() % 2 == 0;
    }
}
