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

        return 0;
    }
}
