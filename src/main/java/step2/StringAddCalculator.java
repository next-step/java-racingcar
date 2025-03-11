package step2;

import java.util.Arrays;
import java.util.regex.Matcher;

import static step2.util.StringParser.CUSTOM_DELIMITER_PATTERN;
import static step2.util.StringParser.NEGATIVE_PATTERN;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        if (NEGATIVE_PATTERN.matcher(input).matches()) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            final String delimiter = matcher.group(1);
            return sumStringArray(matcher.group(2).split(delimiter));
        }

        if (input.contains(",") || input.contains(":")) {
            return sumStringArray(input.split("[,:]"));
        }

        return Integer.parseInt(input.strip());
    }

    private static int sumStringArray(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
