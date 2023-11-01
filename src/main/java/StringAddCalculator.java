import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (validate(input)) {
            String[] tokens = split(input);
            return sum(tokens);
        }
        return 0;
    }

    private static boolean validate(String text) {
        if (text == null) {
            return false;
        }
        if (text.isEmpty()) {
            return false;
        }
        return true;
    }

    private static String[] split(String text) {
        String delimiter = ",|:";
        String customDelimiter = findDelimiter(text);
        if (customDelimiter == null) {
            return text.split(delimiter);
        }
        return text.substring(4).split(delimiter + "|" + customDelimiter);
    }

    private static String findDelimiter(String text) {
        Matcher delimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (delimiterMatcher.find()) {
            return delimiterMatcher.group(1);
        }
        return null;
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            checkPositive(number);
            result += number;
        }
        return result;
    }

    private static void checkPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("Negative numbers are not allowed.");
        }
    }
}
