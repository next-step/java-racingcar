package racinggame.domain;

public class Trial {

    private static final String BLANK = "\\s+";
    private static final String EMPTY_STRING = "";

    private final int value;

    public Trial(final String value) {
        this.value = parse(value);
    }

    public int getValue() {
        return this.value;
    }

    private int parse(final String inputTrial) {
        final String removedBlankInput = removeBlank(inputTrial);

        Validator.checkIsBlank(removedBlankInput);
        Validator.isNumber(removedBlankInput);

        return Integer.parseInt(removedBlankInput);
    }

    private String removeBlank(final String trial) {
        return trial.replaceAll(BLANK, EMPTY_STRING);
    }
}
