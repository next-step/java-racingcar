package calculator.deque;

public class ElementDequeFactory {
    private static final String SPLIT_SPACE_CHAR = " ";

    public static ElementDeque createElementDeque(String input) {
        if(isNullOrEmptyInput(input)) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        String[] splitInput = splitInput(input);
        return new ElementDeque(splitInput);
    }

    private static boolean isNullOrEmptyInput(String input) {
        if (input == null)
            return true;

        return input.trim().equals("");
    }

    private static String[] splitInput(String input) {
        return input.split(SPLIT_SPACE_CHAR);
    }
}
