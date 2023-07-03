package delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DelimiterResolver {

    public static final String BASIC_DELIMITER = ",|:";

    private DelimiterResolver() {
    }

    public static String[] resolve(String text) {
        Matcher delimiterMatcher = Pattern.compile("//(.)\n(.*)")
                                          .matcher(text);

        String delimiter = BASIC_DELIMITER;
        if (delimiterMatcher.find()) {
            delimiter += "|" + delimiterMatcher.group(1);
            text = delimiterMatcher.group(2);
        }

        return new String[] { delimiter, text };
    }

}
