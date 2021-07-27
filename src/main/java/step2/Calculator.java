package step2;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        String operator = values[1];
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        return calculate(operator, first, second);
    }

    private static int calculate(String operator, int first, int second) {
        if ("+".equals(operator)) {
            return sum(first, second);
        } else if ("-".equals(operator)) {
            return sub(first, second);
        } else if ("*".equals(operator)) {
            return mul(first, second);
        }
        return div(first, second);
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
