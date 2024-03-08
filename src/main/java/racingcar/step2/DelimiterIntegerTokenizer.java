package racingcar.step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterIntegerTokenizer {

    private final Pattern CUSTOM_DELIMITER_PATTERN_COMPILED = Pattern.compile("//(.)\n(.*)");
    private final String DEFAULT_DELIMITER_REGEX_PATTERN = ",|:";

    private final int TARGET_INDEX = 2;
    private final int CUSTOM_DELIMITER_INDEX = 1;

    public List<Integer> tokenize(String input) {
        String target = input;
        String regexPattern = DEFAULT_DELIMITER_REGEX_PATTERN;

        Matcher m = CUSTOM_DELIMITER_PATTERN_COMPILED.matcher(input);
        if (m.find()) {
            target = m.group(TARGET_INDEX);
            regexPattern += ("|" + m.group(CUSTOM_DELIMITER_INDEX));
        }

        return tokenizeTargetByRegexPattern(target, regexPattern);
    }

    private List<Integer> tokenizeTargetByRegexPattern(String target, String regexPattern) {
        return Arrays.stream(target.split(regexPattern))
                .map(this::parsePositiveInt)
                .collect(Collectors.toList());
    }

    private int parsePositiveInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException("덧셈 요소로는 숫자만 사용 가능합니다.");
        }
        validateNegative(number);

        return number;
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("덧셈 요소에 음수를 사용할 수 없습니다.");
        }
    }
}
