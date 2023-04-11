package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {

    private final String text;
    private static final String ZERO = "0";
    private static final String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public Split(String text) {
        if (isBlank(text)) {
            this.text = ZERO;
            return;
        }
        this.text = text;
    }

    public String[] getResult() {
        return splitToStringArray();
    }

    private String[] splitToStringArray() {
        Matcher matcher = PATTERN.matcher(this.text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return this.text.split(DELIMITER);
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
