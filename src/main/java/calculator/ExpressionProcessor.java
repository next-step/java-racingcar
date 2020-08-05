package calculator;

import java.util.Objects;

public class ExpressionProcessor {

    public static String[] splitExpression(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException("null 또는 빈 공백의 문자열입니다.");
        }
        return expression.split(" ");
    }
}
