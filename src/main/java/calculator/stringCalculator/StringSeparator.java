package calculator.stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSeparator {
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String ORDINAL_SEPARATOR = COMMA + "|" + COLON;
    public static final String CUSTOM_COMPILER = "//(.)\\n(.*)";

    public List<Integer> separate(String expression) {
        if (hasOrdinalSeparator(expression)) {
            String[] splitStrings = expression.split(ORDINAL_SEPARATOR);
            return sumStrings(splitStrings);
        }

        Matcher matcher = Pattern.compile(CUSTOM_COMPILER).matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] splitStrings = matcher.group(2).split(customDelimiter);
            return sumStrings(splitStrings);
        }

        return sumStrings(new String[]{expression});
    }

    private boolean hasOrdinalSeparator(String expression) {
        return expression.contains(COMMA) || expression.contains(COLON);
    }

    private List<Integer> sumStrings(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
