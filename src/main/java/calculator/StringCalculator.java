package calculator;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class StringCalculator {

    private static Map<String, Operator> operatorMap;
    static {
       operatorMap =  Collections.unmodifiableMap(Stream.of(
                               new SimpleEntry<>("+", Operator.ADD)
                               , new SimpleEntry<>("-", Operator.SUBSTRACT)
                               , new SimpleEntry<>("*", Operator.MULTIPLY)
                               , new SimpleEntry<>("/", Operator.DIVIDE))
                               .collect(toMap(e -> e.getKey(), e -> e.getValue())));
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public int calculate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(" ");
        int result = convertInteger(strings[0]);

        String operator = null;

        for (int i = 1; i < strings.length; i++) {
            if (i % 2 != 0) {
                operator = strings[i];
            }
            if (i % 2 == 0) {
                result = getResult(result, operator, convertInteger(strings[i]));
            }
        }
        return result;
    }

    private int getResult(int result, String operator, int i) {
        if (operatorMap.get(operator) == null) {
            throw new IllegalArgumentException();
        }
        return operatorMap.get(operator).getResult(result, i);
    }

    public int convertInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}
