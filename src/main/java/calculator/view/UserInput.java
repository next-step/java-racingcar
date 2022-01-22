package calculator.view;

import java.util.Scanner;

public class UserInput {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    private Scanner scanner;

    private UserInput() {
        scanner = new Scanner(System.in);
    }

    public static UserInput console() {
        return new UserInput();
    }

    public String getLine() {
        try {
            return validateUserInput(textConsole());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLine();
        }
    }

    public String textConsole() {
        return scanner.nextLine();
    }

    public String validateUserInput(String userInput) {
        return isEmptyString(userInput);
    }

    public String isEmptyString(String userInput) {
        if (userInput.trim().equals("")) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return userInput;
    }
}
