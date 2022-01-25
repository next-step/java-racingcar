package stringCalculator;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class User {

    private static final int MIN_LENGTH = 3;

    public List<String> getUserInput(List<String> userInputTokens) {

        if (userInputTokens.size() < MIN_LENGTH) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다");
        }

        for (String userInputToken : userInputTokens) {
            if (userInputToken.equals("")) {
                throw new IllegalArgumentException("공백이 존재합니다");
            }
        }

        for (int i = 0; i < userInputTokens.size(); i += 2) {
            if (!userInputTokens.get(i).matches("[0-9]+")) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }

        for (int i = 1; i < userInputTokens.size(); i += 2) {
            if (!userInputTokens.get(i).contains("+")
                && !userInputTokens.get(i).contains("-")
                && !userInputTokens.get(i).contains("*")
                && !userInputTokens.get(i).contains("/")) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }
        return userInputTokens;
    }
}