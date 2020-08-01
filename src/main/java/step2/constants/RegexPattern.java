package step2.constants;

import java.util.regex.Pattern;

public class RegexPattern {

    public static final Pattern WHITE_SPACE_REGEX = Pattern.compile("\\s+");
    public static final Pattern NUMBER_REGEX = Pattern.compile("\\d");
    public static final Pattern OPERATOR_REGEX = Pattern.compile("[+*-/]");

    private RegexPattern() {}

}
