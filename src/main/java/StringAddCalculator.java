import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) throws RuntimeException {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }

        String[] numbers;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        } else {
            numbers = input.split(",|:");
        }

        for (String number: numbers) {
            if (number.startsWith("-")) {
                throw new RuntimeException("cannot input negative numbers");
            }
        }

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
