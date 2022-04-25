package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitMatcher {

    private static final String CUSTOM_PATTERN_REGEX = "^//(.)\n(.*)$";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(CUSTOM_PATTERN_REGEX);
    private final Matcher matcher;

    private SplitMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    public static SplitMatcher of(String text) {
        return new SplitMatcher(DEFAULT_PATTERN.matcher(text));
    }

    public static SplitMatcher of(String regex, String text) {
        return new SplitMatcher(Pattern.compile(regex).matcher(text));
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
