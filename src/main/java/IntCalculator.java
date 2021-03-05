public class IntCalculator {
    private final String DELIMITER = " ";
    private final String[] tokens;
    private int iterator = 0;

    public IntCalculator(String request) {
        if (request == null) {
            throw new IllegalArgumentException();
        }
        tokens = request.split(DELIMITER);
        validateToken(tokens);
    }

    public int calculateInOrderFromTheLeft() {
        int left = getNextInt();
        while (hasNext()) {
            IntOperator operator = getNextOperator();
            int right = getNextInt();
            left = operator.operate(left, right);
        }
        return left;
    }

    private boolean hasNext() {
        return iterator < tokens.length;
    }

    private int getNextInt() {
        return parseToInt(tokens[iterator++]);
    }

    private IntOperator getNextOperator() {
        return IntOperator.of(tokens[iterator++]);
    }

    private int parseToInt(String stringValue) {
        shouldBeAbleToParseToInt(stringValue);
        return Integer.valueOf(stringValue);
    }

    private void shouldBeAbleToParseToInt(String value) {
        try {
            Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateToken(String[] requestTokens) {
        if (requestTokens.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }
}
