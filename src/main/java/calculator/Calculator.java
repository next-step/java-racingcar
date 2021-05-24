package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {

    private String userInput;
    private int result = 0;

    private List<Integer> numbers;
    private List<Operator> operators;

    public Calculator(String userInput) {
        validateUserInput(userInput);
        this.userInput = userInput;
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    private void validateUserInput(String userInput) {
        if (userInput == null || userInput.equals("") || userInput.equals(" ")) {
            throw new IllegalArgumentException("입력값이 없거나 빈 공백 문자입니다.");
        }
    }

    public int calculateUserInput() {
        for (String partialInput : userInput.split(CalculConstant.WHITE_SPACE)) {
            addPartial(partialInput);
        }

        return calculatePartial().pop();
    }

    private void addPartial(String input) {
        String regExp = "^[0-9]*$";
        if (Pattern.matches(regExp, input)) {
            numbers.add(Integer.parseInt(input));
        } else {
            operators.add(Operator.createOperator(input));
        }
    }

    private Stack<Integer> calculatePartial() {
        Collections.reverse(numbers);
        Stack<Integer> results = new Stack<>();
        results.addAll(numbers);

        for(Operator currentOperator: operators) {
            int firstOperand = results.pop();
            int secondOperand = results.pop();

            results.push(currentOperator.operate(firstOperand, secondOperand));
        }

        return results;
    }

}
