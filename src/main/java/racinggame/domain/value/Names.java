package racinggame.domain.value;

import racinggame.exception.EmptyAndNullSourceException;
import racinggame.exception.NumericException;
import racinggame.exception.OverNameLengthException;

import java.util.List;

public class Names {
    private static final int EMPTY = 0;
    private static final int NAME_LENGTH = 5;
    private static final int SOLO = 1;
    private static final String NUMBER_CONFIRM_REGEX = "[+-]?\\d*(\\.\\d+)?";

    private final List<String> names;

    private Names(List<String> names) {
        validateEmpty(names);
        validateNumeric(names);

        this.names = names;
    }

    public static Names createNames(List<String> names) {
        return new Names(names);
    }

    public List<String> list() {
        return names;
    }

    public boolean isSolo() {
        return names.size() == SOLO;
    }

    public int count() {
        return names.size();
    }

    private void validateEmpty(List<String> names) {
        if (names.size() == EMPTY) {
            throw new EmptyAndNullSourceException();
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
