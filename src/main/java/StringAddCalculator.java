import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final int NO_VALUE_RESPONSE = 0;
    public int splitAndSum(String input) {
            if (input == null || input.isBlank()) {
                return NO_VALUE_RESPONSE;
            }

            if (input.length() == 1) {
                return Integer.parseInt(input);
            }

        int[] numbers = split(input);
        return sum(numbers);
    }

    private int[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        String[] stringInts = {};

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            stringInts = matcher.group(2).split(customDelimiter);
        } else {
            stringInts = input.split(",|:");
        }

        return convertStringArrayToIntArray(stringInts);
    }
    private int sum(int[] input) {
        return Arrays.stream(input).peek(value -> {
            if (value < 0) {
                throw new NegativeNumberException("음수값이 입력되었습니다.");
            }
        }).sum();
    }

    private int[] convertStringArrayToIntArray(String[] input) {
        return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
