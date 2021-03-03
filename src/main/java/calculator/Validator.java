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



    public boolean isNotOperation(String input) {
        return true;
    }

    public boolean isNumberAndOperation(String[] splitData) {
        return true;
    }
}
