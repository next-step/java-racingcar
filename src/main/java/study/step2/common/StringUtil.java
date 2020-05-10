package study.step2.common;

import java.util.regex.Pattern;

public class StringUtil {

    private final static String SEPERATOR = " ";
    private final static String NUMBERPATTERN = "^[0-9]+$";

    public static boolean inputCheck(String input){
        throw new IllegalArgumentException();
    }

    public static boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static String [] seperateNumberAndOperator(String input) {
        return input.split(SEPERATOR);
    }

    public static boolean isNumber(String value){
        if (isBlank(value)){ //null체크
            throw new IllegalArgumentException();
            //return false;
        }
        return Pattern.matches(NUMBERPATTERN, value);
    }
}
