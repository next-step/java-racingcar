package step4;

public class InputValidator {

    private static final String NAME_INPUT_FORMAT = "[A-Za-z0-9]{1,5}(,[A-Za-z0-9]{1,5})*";

    public static boolean isInvalidNames(String names) {
        return !names.matches(NAME_INPUT_FORMAT);
    }
}
