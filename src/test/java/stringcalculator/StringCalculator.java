package stringcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class StringCalculator {

    private final Map<Character, Operator> operatorMap = new HashMap<>();

    private String[] tokens;

    public StringCalculator() {
        for (Operator operator : Operator.values()) {
            operatorMap.put(operator.getSymbol(), operator);
        }
    }

    private void verifyInput(String value) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException("input value is null or empty");
    }

    private void verifyTokenSize(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("Does it end with an operator?");
        }
    }

    public int calculate(String input) {
        verifyInput(input);
        tokens = input.split("\\s+");
        verifyTokenSize(tokens);

        return doCalculate();
    }

    private int doCalculate() {
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            char op = tokens[i].charAt(0);
            int num = Integer.parseInt(tokens[i + 1]);

            Operator operator = Optional.ofNullable(operatorMap.get(op))
                .orElseThrow(() -> new IllegalArgumentException("operator not found: " + op));

            result = operator.apply(result, num);
        }

        return result;
    }
}
