package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomSplitter {
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_SEPARATOR);

    public String split(String input){
        String result = "";
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()){
            result = m.group(2);
        }
        return result;
    }

    public boolean isCustomText(String input){
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        return matcher.find();
    }
}
