package StringCalculator;

import java.util.regex.Pattern;

public class ArithmeticRegex implements Regex {

    private String regExp ="^[\\s0-9+\\-*/]*$";

    @Override
    public boolean isValidate(String checkStr) {
        if(!checkStr.matches(regExp)){
            throw new IllegalArgumentException("not permitted literal");
        };
        return true;
    }
}
