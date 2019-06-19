package calculator;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.Long.*;

public class StringCalculator {

    public static Long calculate(Input input) {
        return calculate(input.splitByString());
    }

    private static Long calculate(final String[] strings) {
        LinkedList<String> input = new LinkedList<>(Arrays.asList(strings));
        while (input.size() > 1) {
            input.addFirst(calculate(input.pop(), input.pop(), input.pop()));
        }
        return parseLong(input.pop());
    }

    private static String calculate(final String firstArg, final String expression, final String secondArg) {
        return Math.getBySignAndCalculate(parseLong(firstArg), expression, parseLong(secondArg));
    }
}
