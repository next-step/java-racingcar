package step2;

import java.util.Arrays;
import java.util.List;

public class ExpressionTokenValidator {

    private final List<String> operators = Arrays.asList("+", "-", "*", "/");

    public void validate(String[] tokens) {
        validateTokenCount(tokens);
        validateNumberTokens(tokens);
        validateOperatorTokens(tokens);
    }

    private void validateTokenCount(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("token count should be odd number");
        }
    }

    private void validateNumberTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i += 2) {
            validateNumber(tokens[i]);
        }
    }

    private void validateNumber(String token) {
        if (!token.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("token should be number");
        }
    }

    private void validateOperatorTokens(String[] tokens) {
        for (int i = 1; i < tokens.length; i += 2) {
            validateOperator(tokens[i]);
        }
    }

    private void validateOperator(String token) {
        if (!operators.contains(token)) {
            throw new IllegalArgumentException("token should be operator");
        }
    }
}
