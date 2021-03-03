package calculator;


public class Validator {

    public void isBlankOrEmpty(String input) {
        if(isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String input) {
        return input.equals("");
    }

    public boolean isBlank(String input) {
        return input.equals(" ");
    }

    public void isNotOperation(String input) {
        if(!Operator.isOperation(input)) {
            throw new IllegalArgumentException();
        }
    }


    public void isNumberAndOperation(String[] data) {
        isBlankOrEmpty(data[0]);
        for(int i = 1; i< data.length; i = i + 2) {
            isNotOperation(data[i]);
            isBlankOrEmpty(data[i+1]);
        }
    }
}
