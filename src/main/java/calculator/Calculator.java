package calculator;

import java.util.Arrays;

 class Calculator {
    public static int sum(String text) {
        String[] values = StringTokenizer.tokenString(text);
        Validator.isValidateNum(values);
        return Arrays.stream(values).mapToInt(Integer::parseInt).sum();
    }
}
