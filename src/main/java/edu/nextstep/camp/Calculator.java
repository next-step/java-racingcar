package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern PATTERN = Pattern.compile("^(\\d+)(\\s+[+\\-*/]\\s+\\d+)+$");
    private static final String DELIMITER = "[ ]+";

    public int calculate(String command) {
        final Iterator<String> iter = Arrays.stream(parseCommand(command)).iterator();

        return calculateRecursive(Number.of(iter.next()), iter).toInt();
    }

    public String[] parseCommand(String command) {
        if (command == null || command.isEmpty())
            throw new IllegalArgumentException("command must not be empty: " + command);

        if (!PATTERN.matcher(command).find())
            throw new IllegalArgumentException("invalid input: " + command);

        return command.split(DELIMITER);
    }

    public Number calculateRecursive(Number number, Iterator<String> iter) {
        if (!iter.hasNext())
            return number;

        return calculateRecursive(Operation.of(iter.next()).operate(number, Number.of(iter.next())), iter);
    }
}
