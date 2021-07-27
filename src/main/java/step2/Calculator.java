package step2;

public class Calculator {
    public static int calculate(String value) {
        validate(value);
        return doCalculate(value);
    }

    private static void validate(String value) {
        if(isNullOrEmpty(value)) throw new IllegalArgumentException();
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    private static int doCalculate(String value) {
        String[] values = value.split(" ");
        String operator = values[1];
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        return doCalculate(operator, first, second);
    }

    private static int doCalculate(String operator, int first, int second) {
        if ("+".equals(operator)) {
            return sum(first, second);
        } else if ("-".equals(operator)) {
            return sub(first, second);
        } else if ("*".equals(operator)) {
            return mul(first, second);
        } else if ("/".equals(operator)){
            return div(first, second);
        } else {
            throw new IllegalArgumentException();
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

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
