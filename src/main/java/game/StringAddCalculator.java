package game;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String BASIC_DELIMITER = ",|:";
    private static final String SPECIAL_DELIMITER = "//(.)\n(.*)";
    private static final String NEGATIVE_NUMBER_ERROR = "문자열에 음수가 포함되어 있습니다.";
    private static final Pattern SPECIAL_PATTERN = Pattern.compile(SPECIAL_DELIMITER);

    public static int splitAndSum(String numberStr) {
        if (numberStr == null || numberStr.isBlank()) {
            return 0;
        }

        List<String> numbers = split(numberStr);
        checkPositive(numbers);

        return numbers.stream()
                      .mapToInt(Integer::parseInt)
                      .sum();
    }

    private static List<String> split(String numberStr) {
        Matcher m = SPECIAL_PATTERN.matcher(numberStr);
        if (m.find()) {
            String delimiter = m.group(1);
            return List.of(m.group(2).split(delimiter));
        }

        return List.of(numberStr.split(BASIC_DELIMITER));
    }

    private static void checkPositive(List<String> numbers) {
        for (String number : numbers) {
            int parsedInt = Integer.parseInt(number);
            if (parsedInt < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR + " - " + number);
            }
        }
    }
}
