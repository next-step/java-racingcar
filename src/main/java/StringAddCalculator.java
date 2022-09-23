import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens;
        Matcher m = CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(",|:");
        }

        return Arrays.stream(tokens)
                .mapToInt(token -> {
                    int n = Integer.parseInt(token);
                    if (n < 0) throw new RuntimeException("contains negative number : " + n);
                    return n;
                })
                .sum();
    }
}
