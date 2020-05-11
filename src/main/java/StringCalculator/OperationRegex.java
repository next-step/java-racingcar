package StringCalculator;

public class OperationRegex implements Regex {

    private String regExp ="^[+\\-*/]*$";

    @Override
    public boolean isValidate(String checkStr) {
        if(checkStr.matches(regExp)){
            return true;
        };
        return false;
    }
}
