package calculator;

public class StringAddCalculator {
    public static String SEPARATOR = ",|:";
    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] numbers = text.split(SEPARATOR);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
