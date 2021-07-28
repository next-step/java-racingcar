package step2;

public class InputSeparator {
    private static final String SEPARATOR = " ";

    private InputSeparator() {}

    private static boolean checkInputIsEmpty(String input) {
        return input == null || input.equals("");
    }

    public static String[] separate(String input) {
        if (checkInputIsEmpty(input))
            throw new IllegalArgumentException("input 값은 null 또는 공백 문자열이 올수 없습니다.");

        return input.split(SEPARATOR);
    }
}
