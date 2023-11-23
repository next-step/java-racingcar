package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final String DEFAULT_DELIMITER = "[,:]";

    private TextParser() {}

    public static int[] parsedText(String inputString) {
        return toInt(toSplitText(inputString).split(delimiter(inputString)));
    }

    private static String delimiter(String text) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = delimiterMatcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
        }
        return delimiter;
    }

    private static Matcher delimiterMatcher(String text) {
        return DELIMITER_PATTERN.matcher(text);
    }

    private static String toSplitText(String text) {
        Matcher matcher = delimiterMatcher(text);
        if (matcher.find()) {
            text = matcher.group(2);
        }
        return text;
    }

    private static int[] toInt(String[] stringValues) {
        int valueLength = stringValues.length;
        int[] intValues = new int[valueLength];
        for (int i = 0; i < valueLength; i++) {
            intValues[i] = Integer.parseUnsignedInt(stringValues[i]);
        }
        return intValues;
    }
}
