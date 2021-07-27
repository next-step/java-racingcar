package step2;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        String operator = values[1];
        return calculate(operator, first, second);
    }

    private static int calculate(String operator, int first, int second) {
        if ("+".equals(operator)) {
            return first + second;
        } else if ("-".equals(operator)) {
            return first - second;
        } else if ("*".equals(operator)) {
            return first * second;
        }
        return first / second;
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
