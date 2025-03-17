package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterReader {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public boolean hasCustomDelimiter(String s) {
        if (s.matches(CUSTOM_PATTERN.pattern())) {
            return true;
        }
        return false;
    }

    public String[] extractAndSplit(String s) {
        Matcher matcher = CUSTOM_PATTERN.matcher(s);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        throw new IllegalArgumentException("매치가 없습니다");
    }
}
