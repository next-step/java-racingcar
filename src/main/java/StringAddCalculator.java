import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
    private static final String COMMON_DELIMITER_PATTERN = ",|:|";

    public static int splitAndSum(String text) {
        if(isEmpty(text)) {
            return 0;
        }

        String[] splitText = split(text);

        return sum(splitText);
    }

    private static int sum(String[] input) {
        int sum = 0;
        for (String s : input) {
            int n = Integer.parseInt(s);
            isNegative(n);
            sum += n;
        }

        return sum;
    }

    private static void isNegative(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("음수가 들어오면 안됩니다.");
        }
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(COMMON_DELIMITER_PATTERN + "|" +customDelimiter);
        }
        return text.split(COMMON_DELIMITER_PATTERN);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
