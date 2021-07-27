package step2;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        return first + second;
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
