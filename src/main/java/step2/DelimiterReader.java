package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterReader {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Integer CUSTOM_DELIMITER_INDEX = 1;
    private static final Integer EXTRACTED_TEXT_INDEX = 2;

    public boolean hasCustomDelimiter(String text) {
        if (text.matches(CUSTOM_PATTERN.pattern())) {
            return true;
        }
        return false;
    }

    public String[] extractAndSplit(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(EXTRACTED_TEXT_INDEX).split(matcher.group(CUSTOM_DELIMITER_INDEX));
        }
        throw new IllegalArgumentException("커스텀 구분자의 사용이 잘못 되었습니다.");
    }
}
