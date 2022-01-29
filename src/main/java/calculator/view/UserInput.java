package calculator.view;

import java.util.Scanner;

public class UserInput {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    private final Scanner scanner =  new Scanner(System.in);

    public UserInput() {

    }

    public UserInput(String test) {
        validateUserInput(test);
    }

    public String typeUserInput() {
        try {
            return getUserInputFrom(userConsole());
        } catch (IllegalArgumentException e) {
            return typeUserInput();
        }
    }

    public String getUserInputFrom(String userInput) {
        validateUserInput(userInput);
        return userInput;
    }

    private String userConsole() {
        return scanner.nextLine();
    }

    private String validateUserInput(String userInput) {
        checkEmptyString(userInput);
        return userInput;
    }

    private void checkEmptyString(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
