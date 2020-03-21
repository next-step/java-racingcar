package StringCalculator;

public class InputString {
    final private static String BLANK = " ";
    final private static String EMPTY_STRING = "";
    final private static int MINIMUM_ARRAY_LENGTH = 3;

    final private String[] stringList;

    public InputString(final String inputStr) {
        this.validateInputString(inputStr);
        this.stringList = splitInputString(inputStr);
        this.validateStringArrayNumber();
    }

    public String[] getStringList() {
        return this.stringList;
    }

    private void validateInputString(final String inputStr) {
        if (inputStr == null || inputStr.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStringArrayNumber() {
        if (this.stringList.length < MINIMUM_ARRAY_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private String[] splitInputString(final String inputStr) {
        return inputStr.split(BLANK);
    }
}
