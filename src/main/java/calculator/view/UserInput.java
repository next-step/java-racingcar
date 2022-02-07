package calculator.view;

import java.util.Scanner;

public class UserInput {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    private final Scanner scanner = new Scanner(System.in);

    public UserInput() {}

    public UserInput(String test) {
        checkEmptyString(test);
    }

    public String typeUserInput() {
        try {
            return getUserInputFrom(userConsole());
        } catch (IllegalArgumentException e) {
            return typeUserInput();
        }
    }

    private String getUserInputFrom(String userInput) {
        checkEmptyString(userInput);
        return userInput;
    }

    private String userConsole() {
        return scanner.nextLine();
    }

    private void checkEmptyString(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
