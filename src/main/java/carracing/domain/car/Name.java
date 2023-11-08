package carracing.domain.car;

import carracing.utils.exception.CarNameExceedMaxLengthException;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;
    private final String name;

    private Name(String name) {
        this.name = name;
        validateMaximumLength();
    }

    public String getName() {
        return name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    private void validateMaximumLength() {
        if (this.name.length() > MAXIMUM_LENGTH) {
            throw new CarNameExceedMaxLengthException();
        }
    }
}
