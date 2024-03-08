import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(?<key>;)\n.*");
    private static final String COMMON_SEPARATOR = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] inputs = split(input);
        return sum(inputs);
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(input.indexOf("\n") + 1).split(matcher.group("key"));
        }
        return input.split(COMMON_SEPARATOR);
    }

    private static int sum(String[] inputs) {
        int result = 0;
        for (String input : inputs) {
            int item = Integer.parseInt(input);
            if (item < 0) {
                throw new RuntimeException();
            }
            result += item;
        }
        return result;
    }
}

