package step2;

public class Calculator {

    public static int plus(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        if (isOperator(operation[1])) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) + Integer.parseInt(operation[2]);
    }

    public static int minus(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        if (isOperator(operation[1])) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) - Integer.parseInt(operation[2]);
    }

    public static int multiply(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        if (isOperator(operation[1])) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) * Integer.parseInt(operation[2]);
    }

    public static int divide(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        if (isOperator(operation[1])) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) / Integer.parseInt(operation[2]);
    }

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isOperator(String operator) {
        char op = operator.charAt(0);
        return !(op == '+' || op == '-' || op == '*' || op == '/');
    }
}
