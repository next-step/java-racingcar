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

    private void splitUserInput(String userInput) {
        this.splitedInput = Arrays.asList(userInput.split(" "));
    }

    private void validateSplitedInput() {
        if (!validateNumber()) {
            throw new IllegalArgumentException(CalculatorException.INVALID_NUMBER);
        }

        if (!validateArithmetic()) {
            throw new IllegalArgumentException(CalculatorException.INVALID_ARITHMATIC);
        }

        if (!validateDivideZero()) {
            throw new IllegalArgumentException(CalculatorException.INVALID_DIVIDENUMBER);
        }
    }

    private Boolean validateNumber() {
        if (splitedInput.size() % 2 == 0) {
            return false;
        }

        for (int i = 0; i < splitedInput.size(); ++i) {
            boolean isNumber = Character.isDigit(splitedInput.get(i).charAt(0));

            if (i % 2 == 0 && !isNumber) {
                return false;
            }
        }

        return true;
    }

    private void validateUserInputEmpty(String userInput) {
        if (userInput.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean validateArithmetic() {
        for (int i = 0; i < splitedInput.size(); ++i) {
            boolean isArithmetic = splitedInput.get(i).matches("[-*/+]");

            if (i % 2 == 1 && !isArithmetic) {
                return false;
            }
        }

        return true;
    }

    private Boolean validateDivideZero() {
        for (int i = Constant.INIT_ARITHMETIC; i < splitedInput.size(); ++i) {
            boolean isZero = splitedInput.get(i).matches("0");
            boolean isDivideBeforeZero = splitedInput.get(i - 1).matches("/");

            if (i % 2 == 0 && isZero && isDivideBeforeZero) {
                return false;
            }
        }

        return true;
    }
}
