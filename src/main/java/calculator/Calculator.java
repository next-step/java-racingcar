package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private String userInput;
    private int result = 0;
    private Operator currentOperator = Operator.PLUS;

    public Calculator(String userInput) {
        this.userInput = userInput;
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

        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(input)) {
                currentOperator = operator;
            }
        }

        throw new IllegalArgumentException();

    }

}
