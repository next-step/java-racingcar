package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitUtils {
    private static final Pattern pattern = Pattern.compile("^[0-9]+$");
    private static final Pattern splitPattern = Pattern.compile("//(.+)\n(.*)");

    public static List<Integer> toNumbers(String text) {
        Matcher matcher = splitPattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return Arrays.stream(tokens)
                    .map(SplitUtils::toPositiveNumber)
                    .collect(Collectors.toList());
        }
        return Arrays.stream(text.split("[,;:]"))
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

        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 정수만 입력할 수 있습니다.");
        }

        return Integer.parseInt(input);
    }
}
