package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private String userInput;
    private int result = 0;
    private Operator currentOperator;

    public Calculator(String userInput) {
        validateUserInput(userInput);
        this.userInput = userInput;
    }

    private void validateUserInput(String userInput) {
        if (userInput == null || userInput.equals(" ")) {
            throw new IllegalArgumentException("입력값이 없거나 빈 공백 문자입니다.");
        }
    }

    public int calculateUserInput() {
        for (String partialInput : userInput.split(CalculConstant.WHITE_SPACE)) {
            calculatePartial(partialInput);
        }

        return result;
    }

    private void calculatePartial(String input) {
        String regExp = "^[0-9]*$";

        if (Pattern.matches(regExp, input)) {
            result = currentOperator.operate(result, Integer.parseInt(input));
        }

        currentOperator = currentOperator.createOperator(input);
    }

}
