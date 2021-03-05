package step2;

public class Calculator {

    public static int plus(String input) {
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) + Integer.parseInt(operation[2]);
    }

    public static int minus(String input) {
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) - Integer.parseInt(operation[2]);
    }

    public static int multiply(String input) {
        String[] operation = input.split(" ");
        return Integer.parseInt(operation[0]) * Integer.parseInt(operation[2]);
    }
}
