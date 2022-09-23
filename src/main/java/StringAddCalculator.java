import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens = convertTextToTokens(text);

        return Arrays.stream(tokens)
                .mapToInt(Integer::parseUnsignedInt)
                .sum();

    }

    private static String[] convertTextToTokens(String text) {
        Matcher m = CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }
}
