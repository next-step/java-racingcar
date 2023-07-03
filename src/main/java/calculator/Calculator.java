package calculator;

import java.util.Arrays;

public class Calculator {

    public static int sum(String text) {
        if (text == null || text.isEmpty()) return 0;

        String[] tokens = text.split(",");
        int result = 0;
        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }
}
