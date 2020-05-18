package caculator;

public class InputProcessor {
    private static final String SPLIT_TOKEN = " ";

    public String[] process(final String input) {
        validateNullOrEmpty(input);

        String[] splitInput = input.split(SPLIT_TOKEN);
        validateSplitInputLength(splitInput);
        validateNumber(splitInput);
        return splitInput;
    }

    private void validateNullOrEmpty(final String input) {
        if (isBlank(input)) throw new IllegalArgumentException();
    }

    private boolean isBlank(final String input) {
        return input == null || input.trim().length() == 0;
    }

    private void validateSplitInputLength(final String[] splitInput) {
        if (splitInput.length % 2 == 0) throw new IllegalArgumentException();
    }

    private void validateNumber(final String[] splitInput) {
        for (int i = 0; i < splitInput.length; i += 2) {
            if (Double.isNaN(Double.parseDouble(splitInput[i]))) throw new IllegalArgumentException();
        }
    }
}
