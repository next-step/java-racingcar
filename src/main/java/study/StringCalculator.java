package study;

public class StringCalculator {

    public int calculate(String expression) {
        String[] splitExpression = expression.split(" ");
        int result = 0;

        for (int i = 2; i < splitExpression.length; i += 2) {
            if (i == 2) {
                result = Integer.parseInt(splitExpression[i - 2]);
            }

            int targetNumber = Integer.parseInt(splitExpression[i]);
            String symbol = splitExpression[i - 1];

            result = calculateWithSymbol(result, targetNumber, symbol);
        }

        return result;
    }

    private int calculateWithSymbol(int value1, int value2, String symbol) {
        if ("+".equals(symbol)) {
            return value1 + value2;
        }

        if ("-".equals(symbol)) {
            return value1 - value2;
        }

        if ("*".equals(symbol)) {
            return value1 * value2;
        }

        if ("/".equals(symbol)) {
            return value1 / value2;
        }

        throw new IllegalArgumentException("invalid calculate symbol");
    }
}
