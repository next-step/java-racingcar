package calculator;

public class Input {
    private static final String WHITE_SPACE= " ";

    public String[] isSplit(String testInput) {
        if (checkBlank(testInput)) {
            throw new IllegalArgumentException();
        }
        return splitter(testInput);
    }

    public String[] splitter(String input) {
        return input.split(WHITE_SPACE);
    }

    private Boolean checkBlank(String blankValue) {
        return (blankValue == null || blankValue.equals(" ") || blankValue.equals(""));
    }
}
