package step2;

public class Calculator {

    public static int plus(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) + Integer.parseInt(operation[2]);
    }

    public static int minus(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) - Integer.parseInt(operation[2]);
    }

    public static int multiply(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) * Integer.parseInt(operation[2]);
    }

    public static int divide(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) / Integer.parseInt(operation[2]);
    }
}
