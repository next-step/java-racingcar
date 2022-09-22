package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Converter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static final int GROUP_NUMBER_OF_DELIMITER = 1;
    private static final int GROUP_NUMBER_OF_STRING_NUMBERS = 2;

    public List<Integer> convert(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return splitWithDelimiter(matcher.group(GROUP_NUMBER_OF_STRING_NUMBERS), matcher.group(GROUP_NUMBER_OF_DELIMITER));
        }
        return splitWithDelimiter(input, DEFAULT_DELIMITER);
    }

    private List<Integer> splitWithDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(this::parsePositiveIntOrThrow)
                .collect(Collectors.toList());
    }

    private int parsePositiveIntOrThrow(String str) {
        int num = Integer.parseInt(str);
        if (num < 0) {
            throw new RuntimeException("음수를 전달할 수 없습니다.");
        }
        return num;
    }

}
