package step2;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        String operator = values[1];
        if ("+".equals(operator)) {
            return first + second;
        }
        return first - second;
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
