
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern DIVIDER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER  = ",|:";

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .peek(stringNumber -> {
                    if (!stringNumber.matches("^[0-9]*$")) {
                        throw new RuntimeException("숫자가 아닌 값이나 음수가 포함되어 있습니다.");
                    }
                })
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;

        // Find custom divider
        Matcher m = DIVIDER_PATTERN.matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        String[] stringNumbers = text.split(delimiter);

        return sum(stringNumbers);

    }
}