package calculator;

import java.util.Scanner;
import java.io.IOException;

public class UserInput {
    Scanner scan = new Scanner(System.in);
    String[] inputArr;

    public UserInput() throws IOException {
        String userInput = "";
        try {
            userInput = console();
            validateUserInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] " + e);
        }
        inputArr = split(userInput);
    }

    private String console() throws IOException {
        return scan.nextLine();
    }

    private String[] split(String userInput) {
        return userInput.trim().split("\\s+");
    }

    private void validateUserInput(String userInput) {
        isEmptyString(userInput);
    }

    private void isEmptyString(String userInput) {
        if (userInput.trim().equals("")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
