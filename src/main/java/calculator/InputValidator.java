package calculator;

public class InputValidator {
    String input;

    public InputValidator(String input) {
        this.input = input;
    }

    public void validInput() {
        String[] inputArr = input.split(" ");

        if(input.isEmpty() || (inputArr.length > 2 && inputArr.length % 2 == 0))
            throw new IllegalArgumentException("올바르게 입력해주세요.");
    }

    public void validNumber(String num) {
        String regex = "^[0-9]+$";

        if(!num.matches(regex))
            throw new NumberFormatException("숫자를 입력해주세요");
    }
}
