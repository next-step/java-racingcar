package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Console {

    private String userInput;
    private List<String> splitedInput;

    public String readLine() {
        Scanner scanner = new Scanner(System.in);

        setUserInput(scanner.nextLine());
        splitUserInput(userInput);

        validateUserInput();

        return null;
    }

    private void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    private void splitUserInput(String userInput) {
        this.splitedInput = Arrays.asList(userInput.split(" "));
    }

    private void validateUserInput() {
        if (!validateNumber() || !validateArithmetic()) {
            throw new IllegalArgumentException();
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

    private Boolean validateArithmetic() {
        for (int i = 0; i < splitedInput.size(); ++i) {
            boolean isArithmetic = splitedInput.get(i).matches("[-*/+]");

            if (i % 2 == 1 && !isArithmetic) {
                return false;
            }
        }

        return true;
    }

}
