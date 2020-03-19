package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean checkPattern(String str) {

        Pattern regExp = Pattern.compile("(^[0-9]*)\\s([^\\+|\\-|\\*|\\/])\\s([0-9]*)");
        Matcher matcher = regExp.matcher(str);

        if(!matcher.find()) {
            return false;
        }
        return true;
    }

}

