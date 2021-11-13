package racinggame;

import racinggame.exception.EmptyAndNullSourceException;
import racinggame.exception.NumericException;
import racinggame.exception.OverNameLengthException;

import java.util.List;

public class Names {
    private static final int EMPTY = 0;
    private static final int NAME_LENGTH = 5;
    private static final String NUMBER_CONFIRM_REGEX = "[+-]?\\d*(\\.\\d+)?";

    private final List<String> names;

    private Names(List<String> names) {
        validateNameLength(names);
        validateEmpty(names);
        validateNumeric(names);

        this.names = names;
    }

    public static Names createNames(List<String> names) {
        return new Names(names);
    }

    public List<String> names() {
        return names;
    }

    public int count() {
        return names.size();
    }

    private void validateEmpty(List<String> names) {
        if (names.size() == EMPTY) {
            throw new EmptyAndNullSourceException();
        }
    }

    private void validateNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > NAME_LENGTH) {
                throw new OverNameLengthException();
            }
        }
    }

    private static void validateNumeric(List<String> names) {
        for (String name : names) {
            validateNumeric(name);
        }
    }

    private static void validateNumeric(String name) {
        if (name.matches(NUMBER_CONFIRM_REGEX)) {
            throw new NumericException();
        }
    }
}
