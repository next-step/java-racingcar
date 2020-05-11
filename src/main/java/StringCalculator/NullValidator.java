package StringCalculator;

public class NullValidator implements Validator{

    @Override
    public void validate(String checkStr) {
        if(checkStr == null || checkStr.trim().length() == 0)
            throw new  IllegalArgumentException("String in Null");
    }

    @Override
    public boolean isValidate(String checkStr) {
        if(checkStr == null || checkStr.trim().length() == 0) {
            return true;
        };
        return false;
    }
}
