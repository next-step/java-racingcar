package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    BufferedReader br;
    String inputStr;
    String[] inputList;

    public UserInput() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        Console();
        validateUserInput(inputStr);

        inputList = split(inputStr);
    }

    private void Console() throws IOException {
        inputStr = br.readLine();
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
