package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<String> listToSum = split(input);

        return sum(listToSum);

    }

    private static List<String> split(String input) {
        String delimiter = ",|:";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        return Arrays.asList(input.split(delimiter));
    }

    private static int sum(List<String> listToSum) {
        return listToSum.stream()
                .mapToInt(stringNumber -> {
                    stringNumber = (stringNumber == null || stringNumber.isEmpty()) ? "0" : stringNumber;

                    int parsedNumber = Integer.parseInt(stringNumber);
                    if (parsedNumber < 0) {
                        throw new RuntimeException("음수는 사용할 수 없습니다.");

                    } else {
                        return parsedNumber;
                    }
                })
                .sum();
    }
}
