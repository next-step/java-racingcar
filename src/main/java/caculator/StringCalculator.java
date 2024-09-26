package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String CUSTOM_DELIMITER_MATCH_PATTERN = "//(.)\\\\n(.*)";
    private static final int CUSTOM_DELIMITER_MATCH_GROUP_NUMBER = 1;
    private static final int PARSING_TARGET_MATCH_GROUP_NUMBER = 2;

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        Matcher matched = Pattern.compile(CUSTOM_DELIMITER_MATCH_PATTERN).matcher(text);
        if (matched.find()) {
            return splitAndSumWithCustomDelimiter(matched);
        }

        String[] tokens = split(text, null);
        List<Integer> parsedNumbers = Arrays.stream(tokens)
                .map(StringCalculator::parseAndValidateToken)
                .collect(Collectors.toList());

        return sum(parsedNumbers);
    }

    private static int splitAndSumWithCustomDelimiter(Matcher matched) {
        String customDelimiter = matched.group(CUSTOM_DELIMITER_MATCH_GROUP_NUMBER);
        String parsingTargetText = matched.group(PARSING_TARGET_MATCH_GROUP_NUMBER);

        String[] tokens = split(parsingTargetText, customDelimiter);
        List<Integer> parsedNumbers = Arrays.stream(tokens)
                .map(StringCalculator::parseAndValidateToken)
                .collect(Collectors.toList());

        return sum(parsedNumbers);
    }

    private static String[] split(String parsingTargetText, String customDelimiter) {
        String regexForSplit = makeRegexForSplit(customDelimiter);
        return parsingTargetText.split(regexForSplit);
    }

    private static String makeRegexForSplit(String customDelimiter) {
        if (customDelimiter == null) {
            return "[" + COMMA + COLON + "]";
        }
        return "[" + COMMA + COLON + customDelimiter + "]";
    }

    private static int parseAndValidateToken(String token) {
        int parsedNumber = Integer.parseInt(token);
        if (parsedNumber < 0) {
            throw new RuntimeException("negative number is not supported");
        }

        return parsedNumber;
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
