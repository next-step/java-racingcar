package step2;

public class Calculator {
    public static int calculate(String value) {
        validate(value);
        return doCalculate(resolveValues(value));
    }

    private static void validate(String value) {
        if (isNullOrEmpty(value))
            throw new IllegalArgumentException("Value is null or empty");
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    private static int doCalculate(String[] values) {
        return doCalculateSequentially(values);
    }

    private static String[] resolveValues(String value) {
        return value.split(" ");
    }

    private static int doCalculateSequentially(String[] values) {
        int result = 0;
        for (int i = 0; i <= values.length - 2; i += 2) {
            String operator = values[i + 1];
            int first = resolveFirst(values, result, i);
            int second = toInt(values[i + 2]);
            result = doCalculate(operator, first, second);
        }
        return result;
    }

    private static int resolveFirst(String[] values, int result, int idx) {
        if (idx != 0) {
            return result;
        }
        return toInt(values[0]);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static int doCalculate(String operator, int first, int second) {
        if ("+".equals(operator)) {
            return sum(first, second);
        } else if ("-".equals(operator)) {
            return sub(first, second);
        } else if ("*".equals(operator)) {
            return mul(first, second);
        } else if ("/".equals(operator)) {
            return div(first, second);
        } else {
            throw new IllegalArgumentException("Unsupported Operation : " + operator);
        }
    }

    private static int sum(int first, int second) {
        return first + second;
    }

    private static int sub(int first, int second) {
        return first - second;
    }

    private static int mul(int first, int second) {
        return first * second;
    }

    private static int div(int first, int second) {
        return first / second;
    }

}
