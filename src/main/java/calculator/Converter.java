package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Converter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public List<Integer> convert(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return splitWithDelimiter(matcher.group(2), matcher.group(1));
        }
        return splitWithDelimiter(input, DEFAULT_DELIMITER);
    }

    private List<Integer> splitWithDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
