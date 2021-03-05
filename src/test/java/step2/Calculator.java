package step2;

public class Calculator {

    public static int plus(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
        if (operation[1].compareTo("+") != 0 &&
            operation[1].compareTo("*") != 0 &&
            operation[1].compareTo("-") != 0 &&
            operation[1].compareTo("/") != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) + Integer.parseInt(operation[2]);
    }

    public static int minus(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
                if (operation[1].compareTo("+") != 0 &&
            operation[1].compareTo("*") != 0 &&
            operation[1].compareTo("-") != 0 &&
            operation[1].compareTo("/") != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) - Integer.parseInt(operation[2]);
    }

    public static int multiply(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
                if (operation[1].compareTo("+") != 0 &&
            operation[1].compareTo("*") != 0 &&
            operation[1].compareTo("-") != 0 &&
            operation[1].compareTo("/") != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) * Integer.parseInt(operation[2]);
    }

    public static int divide(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] operation = input.split(" ");
                if (operation[1].compareTo("+") != 0 &&
            operation[1].compareTo("*") != 0 &&
            operation[1].compareTo("-") != 0 &&
            operation[1].compareTo("/") != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(operation[0]) / Integer.parseInt(operation[2]);
    }
}
