package me.daeho.step2;

import java.util.Arrays;

public class StringCalculator {
    private final static String DELIMITER = " ";

    public int calculate(String formula) {
        String[] values = parsingFormula(formula);
        return operate(values);
    }

    private int operate(String[] values) {
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i+=2) {
            int operand = Integer.parseInt(values[i+1]);
            switch (Operation.getOperation(values[i])) {
                case ADD:
                    result = add(result, operand);
                    break;
                case DIVIDE:
                    result = divide(result, operand);
                    break;
                case MULTIPLY:
                    result = multiply(result, operand);
                    break;
                case SUBTRACT:
                    result = subtract(result, operand);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result;
    }

    String[] parsingFormula(String formula) {
        if(formula == null || formula.trim().isEmpty()) throw new IllegalArgumentException();

        return formula.split(DELIMITER);
    }

    int add(int value1, int value2) {
        return value1 + value2;
    }

    int subtract(int value1, int value2) {
        return value1 - value2;
    }

    int divide(int value1, int value2) {
        return value1 / value2;
    }

    int multiply(int value1, int value2) {
        return value1 * value2;
    }

    private enum Operation {
        ADD("+"),
        SUBTRACT("-"),
        DIVIDE("/"),
        MULTIPLY("*");

        private final String value;

        Operation(String value) {
            this.value = value;
        }

        private String getValue() {
            return value;
        }

        public static Operation getOperation(String value) {
            return Arrays.stream(values())
                    .filter(v -> v.getValue().equals(value))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
