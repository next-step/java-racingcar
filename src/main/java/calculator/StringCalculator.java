package calculator;

public class StringCalculator {
    public static int calculator(String text) {
        String[] values = text.split(" ");

        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        String operator = values[1];

        return calculator(operator, a, b);

    }

    private static int calculator(String operator, int first, int second) {
        if ("+".equals(operator)) {
            return first + second;
        } else if ("-".equals(operator)) {
            return first - second;
        } else if ("*".equals(operator)) {
            return first * second;
        } else if ("/".equals(operator)) {
            return first / second;
        }
        return 0;
    }
}
