package step2.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    WHITE_SPACE_REGEX (Pattern.compile("\\s+")),
    NUMBER_REGEX(Pattern.compile("\\d")),
    OPERATOR_REGEX(Pattern.compile("[+*-/]"));

    private Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(CharSequence input) {
        return this.pattern.matcher(input).matches();
    }

    public String[] split(CharSequence input) {
        return this.pattern.split(input);
    }
}
