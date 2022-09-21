package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String NOTDIGIT_REGEX = "\\D.*";

    public int calculate(String text) {
        if (text == null || text.isBlank()) return 0;

        Stream<Integer> numbers = convert(text);
        return sum(numbers);
    }

    private Stream<Integer> convert(String text) {
        String delimiter = DEFAULT_DELIMITER;
        String matchedText = text;
        Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(text);

        if (m.find()) {
            delimiter = m.group(1);
            matchedText = m.group(2).strip();
        }

        return splitNumbers(matchedText, delimiter);
    }

    private Integer sum(Stream<Integer> numbers) {
        return numbers.mapToInt(Integer::intValue).sum();
    }

    private Stream<Integer> splitNumbers(String matchedText, String delimiter) {
        if (matchedText.isBlank()) return Stream.empty();

        List<String> numbs = Arrays.asList(matchedText.split(escaped(delimiter)));
        validate(numbs, matchedText);

        return numbs.stream().map(Integer::parseInt);
    }

    private String escaped(String value) {
        return "\\".concat(value);
    }

    private void validate(List<String> numbs, String matchedText) {
        if (!numbs.stream().anyMatch(n -> n.matches(NOTDIGIT_REGEX))) return;

        String msg = String.format("%s: only positive number allowed", matchedText);
        throw new RuntimeException(msg);
    }
}
