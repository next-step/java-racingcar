package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean checkValidate(String expression) {

        String pattern ="^\\d+(\\s*[-+*/]\\s*\\d+)+$";

        if(!expression.matches(pattern))
            return false;

        Pattern patternDivideZero = Pattern.compile("[/]\\s*[0]\\s*[-+*/]*");
        Matcher matcher = patternDivideZero.matcher(expression);

        if(matcher.find()) {
            return false;
        }

        return true;

    }
}
