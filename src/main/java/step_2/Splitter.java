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

    private final static String  DEFAULT_DELIMITER = "[,:]";
    private final static String  CUSTOM_DELIMITER  = "//(.)\n(.*)";
    private final static Pattern DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private final static Pattern INTEGER_PATTERN   = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static Function<String, List<String>> split() {
        return text -> {
            List<String> defaultDelimiterResult = split(text);
            List<String> customDelimiterResult  = split(DELIMITER_PATTERN.matcher(text));

            return Stream.of(defaultDelimiterResult, customDelimiterResult)
                    .filter(list -> isDigit().test(list))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        };
    }

    public static List<String> split(String text) {
        return List.of(text.split(DEFAULT_DELIMITER));
    }

    public static List<String> split(Matcher matcher) {
        return matcher.results()
                .map(matchResult -> matchResult.group(2).split(matchResult.group(1)))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    private static Predicate<List<String>> isDigit() {
        return strings -> strings.stream().allMatch(string -> INTEGER_PATTERN.matcher(string).matches());
    }
}