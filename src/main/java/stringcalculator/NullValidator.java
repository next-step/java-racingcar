package stringcalculator;

public class NullValidator implements Validator{

    @Override
    public void validate(String checkStr) {
        if(checkStr == null || checkStr.trim().length() == 0)
            throw new  IllegalArgumentException("String in Null");
    }
}
