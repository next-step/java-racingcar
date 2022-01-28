package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Console {

    private String userInput;
    private List<String> splitedInput;

    public List<String> readLine() {
        Scanner scanner = new Scanner(System.in);

        setUserInput(scanner.nextLine());

        splitUserInput(userInput);

        validateSplitedInput();

        return splitedInput;
    }

    public void printResult(int result) {
        System.out.println(Constant.RESULT_TEXT + result);
    }

    private void setUserInput(String userInput) {
        if (!validateUserInputEmpty(userInput)) {
            throw new IllegalArgumentException(CalculatorException.INVALID_INPUT);
        }

        this.userInput = userInput;
    }

    public boolean validateUserInputEmpty(String userInput) {
        return userInput.length() != 0;
    }

    private void splitUserInput(String userInput) {
        splitedInput = Arrays.asList(userInput.split(" "));
    }

    private void validateSplitedInput() {
        if (!validateNumber(splitedInput)) {
            throw new IllegalArgumentException(CalculatorException.INVALID_NUMBER);
        }
    }

    public boolean validateNumber(List<String> splitedInput) {
        if (splitedInput.size() % 2 == 0) {
            return false;
        }

        String isNumber = "";

        for (int i = Constant.NUMBER_INIT_INDEX; i < splitedInput.size();
            i += Constant.NEXT_ARITHMETIC) {

            isNumber += splitedInput.get(i);
        }

        return isNumber.matches("[0-9]+");
    }
}
