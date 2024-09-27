package calculator;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Source {

    private static final String DEFAULT_DELIMITER = "[:,]";
    ;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+)\n(.*)");

    public String[] split(String input) {
        String param = param(input);
        String delimiter = delimiter(input);
        return param.split(delimiter);
    }

    private String param(String input) {
        return test(input,(matcher -> matcher.group(2))).orElse(input);
    }

    private String delimiter(String input) {
        return test(input,(matcher)->matcher.group(1)).orElse(DEFAULT_DELIMITER);
    }

    private Matcher matcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private Optional<String> test(String input,Function<Matcher,String> function){
        Matcher matcher = matcher(input);
        if (hasCustomDelimiter(matcher)) {
            return Optional.of(function.apply(matcher));
        }
        return Optional.empty();
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }
}