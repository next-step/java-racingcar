package calculator.view;

import java.util.Scanner;

public class UserInput {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String get() {
        try {
            return validateUserInput(Console());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return get();
        }
    }

    public String Console() {
        return scanner.next();
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
