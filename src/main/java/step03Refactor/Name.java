package step03Refactor;

import static step03Refactor.Config.*;

public class Name {
    private final String name;

    public Name(String name) {
        checkValidate(name);
        this.name = name;
    }

    private void checkValidate(String name) {
        if (name.length() <= 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

}
