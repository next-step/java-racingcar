import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern commaOrColon = Pattern.compile(",|:");
    private static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");
    private static final Pattern NUMERIC_REGEX = Pattern.compile("\\d+");

    public static int splitAndSum(String str) {
        if (isNullOrEmpty(str)) {
            return 0;
        }

        String[] splitTokens = split(str);

        checkValid(splitTokens);

        return getSum(splitTokens);
    }

    private static int getSum(String[] splitTokens) {
        return Arrays.stream(splitTokens)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private static void checkValid(String[] splitTokens) {
        Arrays.stream(splitTokens).forEach(token -> {
            if (Integer.parseInt(token) < 0) {
                throw new RuntimeException("Negative Token");
            }
            if (!NUMERIC_REGEX.matcher(token).matches()) {
                throw new RuntimeException("Non-Numeric Token");
            }
        });
    }

    private static String[] split(String str) {
        Matcher m = CUSTOM_SEPARATOR.matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return commaOrColon.split(str);
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
