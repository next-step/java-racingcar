package calculator;

import org.apache.commons.lang3.StringUtils;
import java.util.regex.Pattern;


public class StringExpressionValidator {

    public static boolean validateExpression(String text) {
        //null | empty check
        if(StringUtils.isEmpty(text)) return false;

        //expression check
        String pattern = "^([0-9]+\\s[\\+\\-\\*\\/]\\s)+[0-9]+$";
        if(!Pattern.matches(pattern, text)) return false;

        return true;
    }

}
