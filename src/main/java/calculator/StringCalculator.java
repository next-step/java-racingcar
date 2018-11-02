package calculator;

public class StringCalculator {
    public static int calculate(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        return calculate(values[1], first, second);
    }

    private static int calculate(String value, int first, int second) {
        if (value.equals("+")) {
            return first + second;
        }
        if (value.equals("-")) {
            return first - second;
        }
        if (value.equals("*")) {
            return first * second;
        }
        if (value.equals("/")) {
            return first / second;
        }
        throw new IllegalArgumentException();
    }
}
