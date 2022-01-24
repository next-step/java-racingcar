package stringCalculator;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class User {

    public List<String> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String[] userInputTokens;
        String userInput = scanner.nextLine();

        userInputTokens = userInput.split(" ");

        if (userInputTokens.length < 3) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다");
        }

        for (String userInputToken : userInputTokens) {
            if (userInputToken.equals("")) {
                throw new IllegalArgumentException("공백이 존재합니다");
            }
        }

        for (int i = 0; i < userInputTokens.length; i += 2) {
            if (!userInputTokens[i].matches("[0-9]+")) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }

        for (int i = 1; i < userInputTokens.length; i += 2) {
            if (!userInputTokens[i].contains("+")
                && !userInputTokens[i].contains("-")
                && !userInputTokens[i].contains("*")
                && !userInputTokens[i].contains("/")) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }
        return Arrays.asList(userInputTokens);
    }
}