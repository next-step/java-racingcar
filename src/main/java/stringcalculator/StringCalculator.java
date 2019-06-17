package stringcalculator;

import java.util.Arrays;
import java.util.Iterator;

public class StringCalculator {

    private static final String DELIMETER = " ";
    private ArithmeticOperator arithmeticOperator = new ArithmeticOperator();

    public String calculate(String input) {
        return calculate(parseInput(input));
    }

    private String[] parseInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("Empty input string");
        }

        String[] tokens = input.split(DELIMETER);
        if (hasInvalidToken(tokens)) {
            throw new IllegalArgumentException("Invalid token");
        }

        return tokens;
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean hasInvalidToken(String[] tokens) {
        return tokens == null || tokens.length == 0 || tokens.length < 3 || isNumberOfTokensEven(tokens);
    }

    private boolean isNumberOfTokensEven(String[] token) {
        return token.length % 2 == 0;
    }
    
    private String calculate(String[] tokens) {
        Iterator<String> iterator = Arrays.stream(tokens).iterator();

        String num1 = iterator.next();
        while (iterator.hasNext()) {
            String symbol = iterator.next();
            String num2 = iterator.next();
            num1 = calculate(symbol, num1, num2);
        }

        return num1;
    }

    private String calculate(String symbol, String num1, String num2) {
        return String.valueOf(arithmeticOperator.operate(ArithmeticOperator.Type.from(symbol),
                Integer.valueOf(num1),
                Integer.valueOf(num2)));
    }
}
