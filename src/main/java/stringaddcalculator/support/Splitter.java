package stringaddcalculator.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private Splitter() {
    }

    private static final String BASE_SPLIT_REGEX = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] splitInputString(final String inputString) {
        Matcher matcher = CUSTOM_PATTERN.matcher(inputString);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return inputString.split(BASE_SPLIT_REGEX);
    }
}
