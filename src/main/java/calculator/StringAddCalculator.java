package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String DELIMITER_DEFUALT_REGEXP = ",|:";
    private final static String DELIMITER_CUSTOM_REGEXP  = "//(.)\n(.*)";

    public static int splitAndSum(String text) {

        if(text == null || text.isBlank())return 0;


        int result = 0;

        Matcher m = Pattern.compile(DELIMITER_CUSTOM_REGEXP).matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            String[] numStrs = m.group(2).split(customDelimiter);

            for (String numStr : numStrs) {
                int number = Integer.parseInt(numStr);
                result += number;
            }
        }else{
            String[] numStrs = text.split(DELIMITER_DEFUALT_REGEXP);
            for (String numStr : numStrs) {
                int number = Integer.parseInt(numStr);
                result += number;
            }
        }

        return result;
    }

}
