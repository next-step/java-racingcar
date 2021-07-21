package study;

import java.util.regex.Pattern;

public class StringUtil {
    private StringUtil() {
    }

    private static final String INPUT_ERROR = "올바른 값을 입력해주세요.";

    public static String[] split(String input, String divider) {
        if (input.isEmpty() || divider.isEmpty() || !divider.equals(",")) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        return input.split(divider);
    }

    public static String deleteBracket(String input) {
        if (!Pattern.matches("^\\([0-9]+,[0-9]+\\)$", input)) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        return input.substring(1, input.length() - 1);
    }

    public static Character getChar(String input, int index) {
        if (input.length() <= index || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, input.length()));
        }
        return input.charAt(index);
    }
}
