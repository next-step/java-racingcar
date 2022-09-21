package step2;

import java.util.Arrays;

public class StringCalculator {
    public int addOperation(String text) {
        if (text == null)
            return 0;
        String[] split = text.split(",|:");
        int result = add(split);
        return result;
    }

    private int add(String[] textArray) {
        return Arrays.stream(textArray).mapToInt(i -> textCheck(i)).sum();
    }

    public int textCheck(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(text);
    }
}
