package calculator.view;

import java.util.Scanner;

public class UserInput {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    private final Scanner scanner;

    private UserInput() {
        scanner = new Scanner(System.in);
    }

    public static UserInput console() {
        return new UserInput();
    }

    public String getLine() {
        try {
            return validateUserInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getLine();
        }
    }

    private String validateUserInput(String userInput) {
        return isEmptyString(userInput);
    }

    private String isEmptyString(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return userInput;
    }
}
