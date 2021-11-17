package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    public static int compute(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must not null or blank");
        }

        List<String> elements = new LinkedList<>(Arrays.asList(input.split(" ")));

        Number left = new Number(popFirst(elements));
        while (elements.size() > 0) {
            Operator operator = Operator.of(popFirst(elements));
            Number right = new Number(popFirst(elements));

            left = operator.operate(left, right);
        }

        return left.number;
    }

    private static String popFirst(List<String> list) {
        return list.remove(0);
    }
}
