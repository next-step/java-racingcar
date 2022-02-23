package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInputValue {
    private static final String BLANK_NAME = "빈 문자열입니다";
    private static final String VALIDATE_NUMBER = "숫자가 올바르게 입력되어 있는지 확인해주세요";
    private static final String VALIDATE_OPERATOR = "연산자가 올바르게 입력되어 있는지 확인해주세요";

    public List<String> userInput() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> userInputTokens = Arrays.asList(input.split(" "));

        validateBlank(userInputTokens);
        validateEmptyNumber(userInputTokens);
        validateEmptyOperation(userInputTokens);

        return userInputTokens;
    }

    public void validateBlank(List<String> userInputTokens) {
        for (String userInputToken: userInputTokens) {
            if (Objects.equals(userInputToken, "")) {
                throw new IllegalArgumentException(BLANK_NAME);
            }
        }
    }

    public void validateEmptyNumber(List<String> userInputTokens) {
        for (int i = 0; i < userInputTokens.size(); i += 2) {
            if (!userInputTokens.get(i).matches("[0-9]+")) {
                throw new IllegalArgumentException(VALIDATE_NUMBER);
            }
        }
    }

    public void validateEmptyOperation(List<String> userInputTokens) {
        for (int i = 1; i < userInputTokens.size(); i += 2) {
            if (!userInputTokens.get(i).contains("+")
                && !userInputTokens.get(i).contains("-")
                && !userInputTokens.get(i).contains("*")
                && !userInputTokens.get(i).contains("/")) {
                throw new IllegalArgumentException(VALIDATE_OPERATOR);
            }
        }
    }
}
