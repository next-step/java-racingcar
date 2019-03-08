package calculator;

public class StringCalculator {

    static String[] inputs;
    static int result;

    static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        inputs = input.split(" ");
        result = Integer.parseInt(inputs[0]);
        for (int i = 1; i < inputs.length; i++) {
            calculate(i);
        }

        return result;
    }

    private static void calculate(int index) {
        if (inputs[index].matches("[+-/*]")) {
            result = calculate(result, Integer.parseInt(inputs[index + 1]), inputs[index]);
        }
    }

    private static int calculate(int a, int b, String operation) {
        if (operation.equals("+")) {
            return add(a, b);
        } else if (operation.equals("-")) {
            return subtract(a, b);
        } else if (operation.equals("/")) {
            return divide(a, b);
        } else if (operation.equals("*")) {
            return multiply(a, b);
        }

        throw new IllegalArgumentException();
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
