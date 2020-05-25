package stringcalculator;

public class OperationValidator implements Validator {

    private String regExp = RegularExpression.OPERATION.getRegExp();

    @Override
    public void validate(String checkStr) {
        if(!checkStr.matches(regExp)){
            throw new IllegalArgumentException("Literal is Not Operation Character");
        };
    }
}
