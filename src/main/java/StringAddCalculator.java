import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return calculate(tokens);
        }

        String[] nums = text.split(",|:");
        return calculate(nums);
    }

    private static int calculate(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new RuntimeException();
            }
            result += num;
        }
        return result;
    }
}
