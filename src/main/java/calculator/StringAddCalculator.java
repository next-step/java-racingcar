package calculator;

public class StringAddCalculator {
    public static String SEPARATOR = ",|:";
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(split(text));
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static String[] split(String text) {
        return text.split(SEPARATOR);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
