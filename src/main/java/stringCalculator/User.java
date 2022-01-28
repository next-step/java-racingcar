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
        validateBlankCarName(userInputTokens);
        validateContainBlank(userInputTokens);
        validateEmptyNumber(userInputTokens);
        validateEmptyOperation(userInputTokens);

        return userInputTokens;
    }

    private void validateBlankCarName(List<String> userInputTokens) {
        for (String userInputToken : userInputTokens) {
            if (userInputToken.equals("")) {
                throw new IllegalArgumentException("공백이 존재합니다");
            }
        }
    }

    private void validateContainBlank(List<String> userInputTokens) {
        if (userInputTokens.size() < MIN_LENGTH) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다");
        }
    }

    private void validateEmptyNumber(List<String> userInputTokens) {
        for (int i = 0; i < userInputTokens.size(); i += 2) {
            if (!userInputTokens.get(i).matches("[0-9]+")) {
                throw new IllegalArgumentException("연속으로 숫자가 입력되었습니다");
            }
        }
    }

    private void validateEmptyOperation(List<String> userInputTokens) {
        for (int i = 1; i < userInputTokens.size()-1; i += 2) {
            if (!userInputTokens.get(i).contains("+")
                && !userInputTokens.get(i).contains("-")
                && !userInputTokens.get(i).contains("*")
                && !userInputTokens.get(i).contains("/")) {
                throw new IllegalArgumentException("연속으로 연산자가 입력되었습니다");
            }
        }
    }
}