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
            return validateUserInput(userConsole());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getLine();
        }
    }

    private String userConsole() {
        return scanner.nextLine();
    }

    public static String validateUserInput(String userInput) {
        return isEmptyString(userInput);
    }

    private static String isEmptyString(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return userInput;
    }
}
