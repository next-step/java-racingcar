package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User {

    private static final int MINIMUM_TOKEN_NUMBER = 3;
    private static final String NOT_NULL_ALLOWED = "올바른 문자열을 입력해주세요";

    public List<String> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String[] userInputTokens = userInput.split(" ");

        if (userInputTokens.length < MINIMUM_TOKEN_NUMBER) {
            throw new IllegalArgumentException(NOT_NULL_ALLOWED);
        }
        for (String token : userInputTokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException(NOT_NULL_ALLOWED);
            }
        }
        return Arrays.asList(userInputTokens);
    }
}
