package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitUtils {
    private static final String DEFAULT_DELIMITERS = "[,;:]";
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");
    private static final Pattern splitPattern = Pattern.compile("//(.+)\n(.*)");

    public static List<Integer> convertToNumbers(String text) {
        Matcher matcher = splitPattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return toNumbers(tokens);
        }
        return toNumbers(text.split(DEFAULT_DELIMITERS));
    }

    private static List<Integer> toNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(SplitUtils::toPositiveNumber)
                .collect(Collectors.toList());
    }

    /**
     * @param input
     * @return 0 이상의 정수
     */
    private static int toPositiveNumber(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        Matcher matcher = numberPattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 정수만 입력할 수 있습니다.");
        }

        return Integer.parseInt(input);
    }
}
