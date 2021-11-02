package edu.nextstep.camp;

public class Calculator {
    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int product(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        return first / second;
    }

    public int calculate(String command) {
        if (command == null || command.isEmpty())
            throw new IllegalArgumentException("command must not be empty: " + command);

        String[] op = command.split(" ");
        int number = Integer.parseInt(op[0]);
        for (int i = 1; i < op.length; i += 2) {
            number = calculate(number, op[i], Integer.parseInt(op[i + 1]));
        }

        return number;
    }

    public int calculate(int first, String operand, int second) {
        switch (operand) {
            case "+":
                return add(first, second);
            case "-":
                return subtract(first, second);
            case "*":
                return product(first, second);
            case "/":
                return divide(first, second);
            default:
                throw new IllegalArgumentException("invalid operand: " + operand);
        }
    }
}
