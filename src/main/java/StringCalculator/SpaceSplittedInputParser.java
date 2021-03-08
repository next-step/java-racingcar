package StringCalculator;

public class SpaceSplittedInputParser implements InputParser {
    final static String delim = " ";
    String[] tokens;
    int popIndex = 0;

    @Override
    public boolean isEmpty() {
        return popIndex >= tokens.length;
    }

    @Override
    public void parse(String input) {
        validateInput(input);
        tokens = input.split(delim);
        popIndex = 0;
    }

    @Override
    public String pop() {
        return tokens[popIndex++];
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input is null");
        }
        if (input.trim().length() == 0) {
            throw new IllegalArgumentException("input is blank");
        }
    }
}

