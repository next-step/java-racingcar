package calculator;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.Long.*;

public class StringCalculator {

    private String input;

    private StringCalculator(String input) {
        this.input = input;
    }

    public static StringCalculator of(final String input) {
        return new StringCalculator(input);
    }

    public Long calculate() {
        return calculate(Input.of(this.input).splitByString());
    }

    private Long calculate(final String[] strings) {
        LinkedList<String> input = new LinkedList<>(Arrays.asList(strings));
        while (input.size() > 1) {
            input.addFirst(calculate(input.pop(), input.pop(), input.pop()));
        }
        return parseLong(input.pop());
    }

    private String calculate(final String firstArg, final String expression, final String secondArg) {
        return Math.createMath(expression)
                .calculate(parseLong(firstArg), parseLong(secondArg))
                .toString();
    }
}
