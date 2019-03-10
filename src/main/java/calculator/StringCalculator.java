package calculator;

import java.util.Arrays;

public class StringCalculator {
    static int run(String text) {
        String[] values = text.split(" ");

        return recursive(values);
    }

    private static int recursive(String[] input) {
        int lastValue = getLastValue(input);
        if (isValue(input)) {
            return lastValue;
        }

        String operator = getOperator(input);
        return calculate(recursive(resize(input)), operator, lastValue);
    }

    private static boolean isValue(String[] input) {
        return input.length == 1;
    }

    private static String getOperator(String[] values) {
        return values[values.length - 2];
    }

    private static int getLastValue(String[] values) {
        return Integer.parseInt(values[values.length - 1]);
    }

    private static String[] resize(String[] values) {
        String[] copy = new String[values.length - 2];
        System.arraycopy(values, 0, copy, 0, values.length - 2);
        return copy;
    }

    private static int calculate(int first, String operator, int second) {
        return Operator.match(operator).calculate(first, second);
    }

}

enum Operator {
    ADD("+") {
        int calculate(int first, int second) {
            return first + second;
        }
    },
    SUB("-") {
        int calculate(int first, int second) {
            return first - second;
        }
    },
    MULTI("*") {
        int calculate(int first, int second) {
            return first * second;
        }
    },
    DIVIDEN("/") {
        int calculate(int first, int second) {
            return first / second;
        }
    };

    String value;

    Operator(String value) {
        this.value = value;
    }

    static Operator match(String operator) {
        return Arrays.stream(Operator.values()).filter(t -> t.value.equals(operator)).findFirst().get();
    }

    abstract int calculate(int first, int second);
}
