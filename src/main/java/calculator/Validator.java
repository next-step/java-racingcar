package calculator;

public class Validator {

    public void isBlankOrEmptyOrNull(String input) {
        if(isBlank(input) || isNull(input) || isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String input) {
        return input.equals("");
    }

    private boolean isNull(String input) {
        return input == null;
    }

    public boolean isBlank(String input) {
        return input.equals(" ");
    }

    public void isNotOperation(String input) {

        if(!isPlus(input) || !isMinus(input)  || !isDivide(input) || !isMultiply(input)) {
            throw new IllegalArgumentException();
        }

    }

    private boolean isPlus(String input) {
        return input.equals("+");
    }

    private boolean isMinus(String input) {
        return input.equals("-");
    }

    private boolean isMultiply(String input) {
        return input.equals("*");
    }

    private boolean isDivide(String input) {
        return input.equals("/");
    }

    public boolean isNumberAndOperation(String[] splitData) {
        return true;
    }
}
