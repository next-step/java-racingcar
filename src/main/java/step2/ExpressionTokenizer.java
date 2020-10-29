package step2;

import java.util.Arrays;
import java.util.List;

public class ExpressionTokenizer {

    private final static List<String> operators = Arrays.asList("+", "-", "*", "/");

    private ExpressionTokenizer() {
    }

    public static String[] getTokens(String expression) {
        return expression.split(" ");
    }

    public static void validate(String[] tokens) {
        validateTokenCount(tokens);
        validateNumberTokens(tokens);
        validateOperatorTokens(tokens);
    }

    private static void validateTokenCount(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("token count should be odd number");
        }
    }

    private static void validateNumberTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i += 2) {
            validateNumber(tokens[i]);
        }
    }

    private static void validateNumber(String token) {
        if (!token.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("token should be number");
        }
    }

    private static void validateOperatorTokens(String[] tokens) {
        for (int i = 1; i < tokens.length; i += 2) {
            validateOperator(tokens[i]);
        }
    }

    private static void validateOperator(String token) {
        if (!operators.contains(token)) {
            throw new IllegalArgumentException("token should be operator");
        }
    }
}
