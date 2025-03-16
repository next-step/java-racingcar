package calculator;

public class StringCalculator {
    public static int calculate(String text) {
        if (text.contains(",")) {
            return getSum(text);
        }
        return Integer.parseInt(text);
    }

    private static int getSum(String text) {
        String[] values = text.split(",");
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value.trim());
        }
        return result;
    }
}
