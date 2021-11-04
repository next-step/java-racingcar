package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Calculator {
    public int calculate(String command) {
        final Iterator<String> iter = parseCommand(command).iterator();

        return calculateRecursive(Number.of(iter.next()), iter).toInt();
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

    public Number calculateRecursive(Number number, Iterator<String> iter) {
        if (!iter.hasNext())
            return number;

        final String operator = iter.next();

        if (!iter.hasNext()) // 연산자를 뽑았는데 다음항이 없다면 입력이 뭔가 잘못됐겠지..
            throw new IllegalArgumentException("invalid input - last element must be operand.");

        return calculateRecursive(Operation.of(operator).operate(number, Number.of(iter.next())), iter);
    }
}
