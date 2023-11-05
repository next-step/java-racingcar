import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int splitAndSum(String text) throws Exception {
        if (checkNullOrEmpty(text)) return 0;
        String[] numbers = splitTextToNumbers(text);
        return sum(numbers);
    }

    private static boolean checkNullOrEmpty(String text) {
        return text == null || text.equals("");
    }

    private static String[] splitTextToNumbers(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static int sum(String[] numbers) throws Exception {
        int result = 0;
        for (String number : numbers) {
            result = result + checkNegative(Integer.parseInt(number));
        }
        return result;
    }

    private static int checkNegative(int number) throws Exception {
        if (number < 0) throw new RuntimeException("Input number is negative");
        return number;
    }
}