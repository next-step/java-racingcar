package calculator.domain;

public class Validator {
    
    public static boolean checkValidate(String expression) {

        String pattern ="^\\d+(\\s*[-+*/]\\s*\\d+)+$";

        return expression.matches(pattern);
    }
}
