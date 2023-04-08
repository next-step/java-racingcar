package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_FIND_REGEX = "//(.*)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toPositiveNumbers(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(List<Integer> numbers) {
        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

//    private static int[] toPositiveNumbers(String[] stringNumbers) {
//        int[] numbers = new int[stringNumbers.length];
//        for (int i = 0; i < stringNumbers.length; i++) {
//            numbers[i] = new PositiveNumber(stringNumbers[i]).valueOf();
//        }
//        return numbers;
//    }

    private static List<Integer> toPositiveNumbers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .map((stringNumber) -> {
                    return new PositiveNumber(stringNumber).valueOf();
                }).collect(Collectors.toList());
    }

    private static String[] split(String text) {
        if (!text.matches(CUSTOM_DELIMITER_FIND_REGEX)) {
            return text.split(DEFAULT_DELIMITER);
        }
        return customDelimiterSplit(text);
    }

    private static String[] customDelimiterSplit(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_FIND_REGEX).matcher(text);
        if (matcher.find()) {
            Delimiter delimiter= new Delimiter(matcher.group(1));

            String targetText = matcher.group(2);
            String delimiterForRegex = DEFAULT_DELIMITER + "|" + delimiter.valueOfRegex();

            return targetText.split(delimiterForRegex);
        }
        throw new RuntimeException("Wrong custom delimiter");
    }
}
