import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    public int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        String[] oprations = extractOperation(input);
        String[] split = split(input);
        int[] values = toInts(split);
        int result = 0;
        for (int i = 0; i < values.length - 1; i++) {
            result += operate(new int[]{values[i], values[i+1]}, oprations[i]);
        }

        return result;
    }

    private static String[] extractOperation(String input) {
        String[] values = new String[input.length() - 1];

        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            }
            values[i] = Character.toString(c);
        }

        return values;
    }


    private static int[] toInts(String[] values) {
        int[] arr = new int[values.length];
        int len = values.length;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        return arr;
    }

    private static boolean isBlank(String input) {
        return input == null;
    }


    private int operate(int[] values, String operation) {
        switch (operation) {
            case "+": return sum(values);
            case "-": return minus(values);
            case "*": return multiply(values);
            case "/": return divide(values);
        }
        throw new IllegalStateException("this operation not support : " + operation);
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public int minus(int[] values) {
        int result = 0;
        for (int value : values) {
            value -= value;
        }
        return result;
    }

    public int multiply(int[] values) {
        int result = 1;
        for (int value : values) {
            result *= value;
        }
        return result;
    }

    public int divide(int[] values) {
        int result = 1;
        for (int value : values) {
            result /= result;
        }
        return result;
    }

    private String[] split(String input) {
        return StringUtils.split(input, "\\+|-");
    }
}
