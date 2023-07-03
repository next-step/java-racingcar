package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int sum(String text) {
        if (!Validator.isValidate(text)) return 0;

        String[] values = Util.tokenString(text);
        return Arrays.stream(values).mapToInt(Integer::parseInt).sum();
    }


}
