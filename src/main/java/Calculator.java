import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.matches()) {
            return sum(split(matcher.group(2), matcher.group(1)));
        }
        return sum(split(input, DEFAULT_DELIMITER_REGEX));
    }

    public static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static Integer sum(String[] inputArray) {
        return Arrays.stream(inputArray)
                .mapToInt(Integer::parseInt)
                .peek(num -> {
                    if (num < 0) throw new RuntimeException();
                })
                .sum();
    }
}
