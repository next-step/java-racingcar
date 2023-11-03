package calculator;

public class StringCalculator {
    public static int cal(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
