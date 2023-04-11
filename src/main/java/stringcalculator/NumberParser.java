package stringcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static stringcalculator.Delimiter.BLANK_STRING;
import static stringcalculator.Delimiter.REGEX_ESCAPE;

public class NumberParser {
    private static final int AFTER_CUSTOM_DELIMITER_INDEX = 1;
    private static final String NUMBER_REGEX = "^-?\\d+";

    public Numbers parse(String text, Delimiters delimiters) {
        String result = text;
        result = replaceDelimiterToBlank(delimiters, result);
        result = removeCustomExpression(result);
        final List<String> stringNumbers = toList(result);
        return Numbers.of(parseNumbers(stringNumbers));
    }

    private List<String> toList(String result) {
        return Arrays.stream(result.split(BLANK_STRING.getValue()))
                .filter(e -> !e.isBlank())
                .collect(Collectors.toList());
    }

    private String removeCustomExpression(String result) {
        if (Delimiter.containsCustomDelimiter(result)) {
            result = result.split(Delimiter.CUSTOM_END_SPLIT.getValue())[AFTER_CUSTOM_DELIMITER_INDEX];
        }
        return result;
    }

    private String replaceDelimiterToBlank(Delimiters delimiters, String result) {
        for (String delimiter : delimiters.getDelimiters()) {
            delimiter = REGEX_ESCAPE.getOrDefault(delimiter, delimiter);
            result = result.replaceAll(delimiter, BLANK_STRING.getValue());
        }
        return result;
    }

    private List<String> parseNumbers(List<String> stringNumbers) {
        if (stringNumbers.isEmpty()) {
            return Collections.emptyList();
        }
        if (notParsable(stringNumbers)) {
            throw new IllegalArgumentException("구분자를 제외하고 숫자가 아닌 문자는 입력할 수 없습니다.");
        }
        return stringNumbers;
    }

    private boolean parsable(List<String> stringNumbers) {
        return stringNumbers.stream()
                .allMatch(e -> e.matches(NUMBER_REGEX));
    }

    private boolean notParsable(List<String> numbers) {
        return !parsable(numbers);
    }
}
