package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

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
        final Iterator<String> iter = parseCommand(command).iterator();

        int number = Integer.parseInt(iter.next());
        while (iter.hasNext()) {
            final String operand = iter.next();

            if (!iter.hasNext()) // 연산자를 뽑았는데 다음항이 없다면 입력이 뭔가 잘못됐겠지..
                throw new IllegalArgumentException("invalid input: " + command);

            number = calculate(number, operand, Integer.parseInt(iter.next()));
        }

        return number;
    }

    public Stream<String> parseCommand(String command) {
        if (command == null || command.isEmpty())
            throw new IllegalArgumentException("command must not be empty: " + command);

        final String[] op = command.split(" ");

        if (op.length < 3)
            throw new IllegalArgumentException("invalid input: " + command);

         return Arrays.stream(op)
                .filter(s -> s != null && !s.isEmpty());
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
