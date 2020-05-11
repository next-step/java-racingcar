package StringCalculator;

public class NumberValidator implements Validator {

    String regExp = RegularExpression.NUMBER.getRegExp();

    @Override
    public void validate(String checkStr) {
        if(!checkStr.matches(regExp)){
            throw new NumberFormatException("Literal is Not Number");
        };
    }

    @Override
    public boolean isValidate(String checkStr) {
        if(checkStr.matches(regExp)){
            return true;
        };
        return false;
    }
}
