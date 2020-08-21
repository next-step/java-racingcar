package pobiStringCalculator;

public class StringCalculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int first = toInt(values[0]);
        int second = toInt(values[2]);
        return first + second;

    }

    private static int toInt(String value) {
        return Integer.parseInt(value);  // i, values -> value
    }
}
