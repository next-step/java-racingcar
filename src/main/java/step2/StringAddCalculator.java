package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        boolean isEmptyInput = "0".equals(convertToZeroIfEmpty(input));
        if (isEmptyInput) {
            return 0;
        }

        List<String> listToSum = split(input);

        return sum(listToSum);
    }

    private static List<String> split(String input) {
        String defaultDelimiter =  ",|:";

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        boolean hasCustomDelimiter = matcher.matches();
        String delimiter = hasCustomDelimiter ? matcher.group(1) : defaultDelimiter;
        String target = hasCustomDelimiter ? matcher.group(2) : input;

        return Arrays.stream(target.split(delimiter))
                .map(StringAddCalculator::convertToZeroIfEmpty)
                .collect(Collectors.toList());
    }

    private static int sum(List<String> listToSum) {
        return listToSum.stream()
                .mapToInt(StringAddCalculator::parsePositiveInt)
                .sum();
    }

    private static String convertToZeroIfEmpty(String number) {
        return (number == null || number.isEmpty()) ? "0" : number;
    }

    private static int parsePositiveInt(String stringNumber) {
        int parsedNumber = Integer.parseInt(stringNumber);
        if (parsedNumber < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");

        } else {
            return parsedNumber;
        }
    }
}
