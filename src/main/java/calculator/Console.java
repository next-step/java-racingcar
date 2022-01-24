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
        validateUserInputEmpty(userInput);

        this.userInput = userInput;
    }

    private void validateUserInputEmpty(String userInput) {
        if (userInput.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void splitUserInput(String userInput) {
        this.splitedInput = Arrays.asList(userInput.split(" "));
    }

    private void validateSplitedInput() {
        if (!validateNumber()) {
            throw new IllegalArgumentException(CalculatorException.INVALID_NUMBER);
        }
    }

    private Boolean validateNumber() {
        if (splitedInput.size() % 2 == 0) {
            return false;
        }

        boolean isNumber = true;

        for (int i = Constant.NUMBER_INIT_INDEX; i < splitedInput.size();
            i += Constant.NEXT_ARITHMETIC) {
            isNumber = Character.isDigit(splitedInput.get(i).charAt(0));
        }

        return isNumber;
    }
}
