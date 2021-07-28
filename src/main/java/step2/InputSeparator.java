package step2;

public class InputSeparator {
    private static final String SEPARATOR = " ";

    private static boolean checkInputIsEmpty(String input) {
        return input == null || input.equals("");
    }

    public static String[] separate(String input) {
        if (checkInputIsEmpty(input))
            throw new IllegalArgumentException();

        return input.split(SEPARATOR);
    }
}
