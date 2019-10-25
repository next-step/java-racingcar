package stringcalculator.parser;

import java.util.Arrays;

public class StringParser {
    private static final String EMPTY = "";
    private static final String BLANK = " ";

    private String[] parsedInputs;

    public void parse(String input) {
        checkLegal(input);
        splitInput(input);
    }

    public String[] getParsedInputs() {
        return Arrays.copyOf(this.parsedInputs, this.parsedInputs.length);
    }

    private void splitInput(String input) {
        this.parsedInputs = input.split(BLANK);
    }

    private void checkLegal(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String input) {
        return (input == null) || (input.equals(EMPTY));
    }
}
