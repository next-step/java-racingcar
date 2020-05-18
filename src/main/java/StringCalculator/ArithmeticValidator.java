package StringCalculator;

public class ArithmeticValidator implements Validator {

    String regExp = RegularExpression.ARITHMETIC.getRegExp();

    @Override
    public void validate(String checkStr) {
        if(!checkStr.matches(regExp)){
            throw new IllegalArgumentException("not permitted literal");
        };
    }
}
