package study.step2;

public class StringCalculator {
    private static final String DELIMITER = " ";
    private static final String[] VALID_OPERATORS = new String[] { "+", "-", "*", "/" };

    int memory;

    public int add(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }

    public int subtract(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }

    public int divide(int leftValue, int rightValue) {
        return leftValue / rightValue;
    }

    public int multiply(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }

    public int calculate(String input) {
        checkEmpty(input);
        String[] parts = input.split(DELIMITER);

        memory = convertToInt(parts[0]);
        for (int i = 1; i < parts.length - 1; i += 2) {
            int convertedNumber = convertToInt(parts[i + 1]);
            memory = evaluatePart(parts[i], convertedNumber);
        }
        return memory;
    }

    private int evaluatePart(String operator, int number) {
        checkValidOperator(operator);
        switch (operator) {
            case "+":
                return add(memory, number);
            case "-":
                return subtract(memory, number);
            case "*":
                return multiply(memory, number);
            case "/":
                return divide(memory, number);
        }

        throw new IllegalArgumentException();
    }

    private void checkEmpty(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("Input shouldn't be empty.");
        }
    }

    private void checkValidOperator(String operator) {
        boolean result = false;
        for (String validOperator : VALID_OPERATORS) {
            result |= validOperator.equals(operator);
        }

        if (!result) {
            throw new IllegalArgumentException(String.format("%s is not operator", operator));
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
