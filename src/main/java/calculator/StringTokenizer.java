package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTokenizer {
    public static final String DEFAULT_DELIMITERS = "[,:]";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static String[] tokenize(String str){
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(str);
        if(matcher.find()){
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }

        return str.split(DEFAULT_DELIMITERS);
    }
}
