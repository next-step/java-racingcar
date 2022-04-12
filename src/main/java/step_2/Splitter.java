package step_2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Splitter {

    private final static Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private final static String DEFAULT_DELIMITER = "[,:]";

    public Function<String, List<String>> split() {
        return text -> {
            List<String> defaultDelimiterResult = split(text);
            List<String> customDelimiterResult = split(CUSTOM_DELIMITER_PATTERN.matcher(text));

            return Stream.of(defaultDelimiterResult, customDelimiterResult)
                    .filter(list -> isDigit().test(list))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        };
    }

    public List<String> split(String text) {
        return List.of(text.split(DEFAULT_DELIMITER));
    }

    public List<String> split(Matcher matcher) {
        return matcher.results()
                .map(matchResult -> matchResult.group(2).split(matchResult.group(1)))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    private Predicate<List<String>> isDigit() {
        return strings -> strings.stream().allMatch(string -> INTEGER_PATTERN.matcher(string).matches());
    }
}