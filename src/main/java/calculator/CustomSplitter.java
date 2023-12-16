package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomSplitter {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_SEPARATOR);
    public String[] split(String input){
        Matcher m = CUSTOM_PATTERN.matcher(input);
        String customSeparator = m.group(1);
        return m.group(2).split(customSeparator);
    }

    public boolean isCustomText(String input){
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()){
            return true;
        }
        return false;
    }
}
