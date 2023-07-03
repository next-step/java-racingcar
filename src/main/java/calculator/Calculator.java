package calculator;

import java.util.Arrays;

public class Calculator {

    public static int sum(String text) {
        if (text == null || text.isEmpty()) return 0;

        String delimiter = "[,;]";

        if (text.startsWith("//") && text.length() >= 4 && text.charAt(3) == '\n') {
            delimiter = text.substring(2, 3);
            text = text.substring(4);
        }

        String[] tokens = text.split(delimiter);
        int result = 0;
        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }
}
