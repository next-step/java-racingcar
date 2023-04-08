import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DELIMITER_REGEX = ",|:";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int INPUT_STRING = 2;
    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }

        String[] splitedNumbers;
        String regex = "//(.)\n(.*)";

        Matcher m = Pattern.compile(regex).matcher(input);
        if (m.find()) {
            String delimiter = m.group(CUSTOM_DELIMITER);
            splitedNumbers = m.group(INPUT_STRING).split(delimiter);
            return sumNumbers(splitedNumbers);
        }

        splitedNumbers = input.split(DELIMITER_REGEX);
        return sumNumbers(splitedNumbers);
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
    private static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    try {
                        int num = Integer.parseInt(number);
                        if (num < 0) {
                            throw new IllegalArgumentException("Negative number found: " + num);
                        }
                        return num;
                    } catch (NumberFormatException ex) {
                        throw new IllegalArgumentException("Invalid number found: " + number);
                    }
                })
                .sum();
    }
}
