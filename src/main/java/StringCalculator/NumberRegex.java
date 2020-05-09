package StringCalculator;

public class NumberRegex implements Regex{

    private String regExp ="^[0-9]*$";

    @Override
    public boolean isValidate(String checkStr) {
        if(checkStr.matches(regExp)){
            return true;
        };
        return false;
    }
}
