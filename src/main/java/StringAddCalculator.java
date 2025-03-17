import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static Integer splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .map(StringAddCalculator::checkNegative)
                    .sum();
        } else {
            String[] numbers = input.split(",|:");
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .map(StringAddCalculator::checkNegative)
                    .sum();
        }
    }

    public static Integer checkNegative(Integer input) {
        if (input < 0) {
            throw new RuntimeException();
        } else {
            return input;
        }
    }
}
