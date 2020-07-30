package study.step2;

import study.step2.operators.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringCalculator {
    private static final String DELIMITER = " ";

    private final Map<String, Operator> operators;

    public StringCalculator() {
        Map<String, Operator> operators = new HashMap<>();
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());

        this.operators = Collections.unmodifiableMap(operators);
    }

    public int calculate(String input) {
        checkEmpty(input);
        String[] parts = input.split(DELIMITER);

        int memory = convertToInt(parts[0]);
        for (int i = 1; i < parts.length; i += 2) {
            Operator operator = getOperator(parts[i]);
            int value = convertToInt(parts[i + 1]);

            memory = operator.evaluate(memory, value);
        }

        return memory;
    }

    private Operator getOperator(String operator) {
        if (!operators.containsKey(operator)) {
            throw new IllegalArgumentException(String.format("%s is not a valid operator", operator));
        }

        return operators.get(operator);
    }

    private void checkEmpty(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("Input shouldn't be empty.");
        }
    }

    private int convertToInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
