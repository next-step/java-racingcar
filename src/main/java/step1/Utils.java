package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    static void stringEmptyValidation(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isNullOrEmpty(String input){
        return input == null || input.trim().isEmpty();
    }

    static boolean isOperator(char charat) {
        boolean operator = "+-*/".contains(charToStringConvert(charat));
        if(!operator){
            throw new IllegalArgumentException();
        }
        return operator;
    }

    static boolean isNumber(char charat){
        Pattern numberPattern = Pattern.compile("(^[0-9]*$)");
        Matcher numberMatch = numberPattern.matcher(charToStringConvert(charat));
        return numberMatch.find();
    }

    static String charToStringConvert(char charat) {
        return String.valueOf(charat);
    }

}
