package calculator;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String BLANK = " ";
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    String input;

    public InputValidator(String input) {
        this.input = input;
    }

    public void validInput() {
        String[] inputArr = input.split(BLANK);

        if(input.isEmpty() || (inputArr.length > 2 && inputArr.length % 2 == 0))
            throw new IllegalArgumentException("올바르게 입력해주세요.");

        for(int i=0; i< inputArr.length; i+=2) {
            validNumber(inputArr[i]);
        }
    }

    public void validNumber(String num) {
        if(!NUMERIC.matcher(num).find())
            throw new NumberFormatException("숫자를 입력해주세요");
    }
}
