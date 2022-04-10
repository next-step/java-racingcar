package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitMatcher {

    private static final String SPLIT_PATTERN_REGEX = "^//(.)\n(.*)$";
    private final Matcher matcher;

    private SplitMatcher(String regex, String text) {
        this.matcher = Pattern.compile(regex).matcher(text);
    }

    public static SplitMatcher of(String text) {
        return SplitMatcher.of(SPLIT_PATTERN_REGEX, text);
    }

    public static SplitMatcher of(String regex, String text) {
        return new SplitMatcher(regex, text);
    }

    public boolean find() {
        return this.matcher.find();
    }

    public String getSplit() {
        return this.matcher.group(1);
    }

    public String getText() {
        return this.matcher.group(2);
    }
}
