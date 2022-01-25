package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputValue {

    public List<String> userInput() {
        String[] userInputTokens;
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        userInputTokens = input.split(" ");

        return Arrays.asList(userInputTokens);
    }
}
