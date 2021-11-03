package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Calculator {
    public int calculate(String command) {
        final Iterator<String> iter = parseCommand(command).iterator();

        return calculateRecursive(Number.of(iter.next()), iter).toInt();
    }

    public Number calculateRecursive(Number number, Iterator<String> iter) {
        if (!iter.hasNext())
            return number;

        final String operand = iter.next();

        if (!iter.hasNext()) // 연산자를 뽑았는데 다음항이 없다면 입력이 뭔가 잘못됐겠지..
            throw new IllegalArgumentException("invalid input - last element is operand:" + operand);

        return calculateRecursive(calculate(number, operand, Number.of(iter.next())), iter);
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

    public Number calculate(Number first, String operand, Number second) {
        switch (operand) {
            case "+":
                return first.add(second);
            case "-":
                return first.subtract(second);
            case "*":
                return first.product(second);
            case "/":
                return first.divide(second);
            default:
                throw new IllegalArgumentException("invalid operand: " + operand);
        }
    }
}
