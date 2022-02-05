package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {

    private static final ArrayList<String> OPERATOR_CHAR = new ArrayList<>(
        Arrays.asList("+", "-", "*", "/"));
    private static final String WHITE_SPACE = " ";

    public static String[] stringCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Null이나 빈 공백 문자는 입력할 수 없습니다.");
        }

        String[] splitInput = input.split(WHITE_SPACE);
        for (int i = 0; i < splitInput.length; i++) {
            if (i % 2 == 1) {
                operatorCheck(splitInput[i]);
            }
        }
        return splitInput;
    }

    private static void operatorCheck(String operatorChar) {
        if (!OPERATOR_CHAR.contains(operatorChar)) {
            throw new IllegalArgumentException("[ERROR] 사칙연산 기호만 입력하세요.");
        }
    }

}
