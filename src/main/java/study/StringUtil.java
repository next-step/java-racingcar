package study;

public class StringUtil {
    private StringUtil() {
    }

    public static String[] split(String input, String divider) {
        if (input.isEmpty() || divider.isEmpty() || !divider.equals(","))
            throw new IllegalArgumentException("올바른 값을 입력해주세요");
        return input.split(divider);
    }

    public static String deleteBracket(String input) {
        return input.substring(1, input.length() - 1);
    }

    public static Character getChar(String input, int index) {
        if (input.length() <= index || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, input.length()));
        }
        return input.charAt(index);
    }
}
