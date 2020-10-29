package step2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class StringCalculator {
    private final ExpressionTokenizer tokenizer = new ExpressionTokenizer();
    private final ExpressionTokenValidator expressionTokenValidator = new ExpressionTokenValidator();
    private final Map<String, BiFunction<Integer, Integer, Integer>> operatorMap = new HashMap<String, BiFunction<Integer, Integer, Integer>>() {{
        put("+", Integer::sum);
        put("-", (num, nextNum) -> num - nextNum);
        put("*", (num, nextNum) -> num * nextNum);
        put("/", (num, nextNum) -> num / nextNum);
    }};

    public Integer execute(String expression) {
        validateInputExpression(expression);
        return calculate(getValidTokens(expression));
    }

    private void validateInputExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("input is null");
        }
    }

    private String[] getValidTokens(String expression) {
        String[] tokens = tokenizer.getTokens(expression);
        expressionTokenValidator.validate(tokens);
        return tokens;
    }

    private Integer calculate(String[] tokens) {
        Integer result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            result = operatorMap.get(tokens[i]).apply(result, Integer.parseInt(tokens[i + 1]));
        }
        return result;
    }
}
