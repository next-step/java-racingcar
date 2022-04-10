package step_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

    private final static String  DEFAULT_DELIMITER = "[,:]";
    private final static String  CUSTOM_DELIMITER  = "//(.)\n(.*)";
    private final static Pattern PATTERN           = Pattern.compile(CUSTOM_DELIMITER);

    public static Function<String, List<String>> split() {
        return text -> {
            String[] result  = text.split(DEFAULT_DELIMITER);
            Matcher  matcher = PATTERN.matcher(text);

            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                result = matcher.group(2).split(customDelimiter);
            }

            return Arrays.stream(result).collect(Collectors.toList());
        };
    }
}