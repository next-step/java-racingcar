import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitPolicy {

    public static final String[] splitByPolicy(String str) {
        String pattern = "//(.)\n(.+)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(str);
        if (!matcher.find()) {
            return str.split(",|;");
        }

        String customDelimiter = matcher.group(1);
        String expression = matcher.group(2);
        if (isMetaCharacter(customDelimiter)) {
            customDelimiter = String.format("\\%s", customDelimiter);
        }
        return expression.split(customDelimiter);
    }

    private static boolean isMetaCharacter(String str) {
        return str.matches("[.,\\\\+*?\\[^\\]$(){}=!<>|:-]");
    }
}
