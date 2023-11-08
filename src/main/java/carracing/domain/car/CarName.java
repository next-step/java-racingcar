package carracing.domain.car;

import carracing.utils.exception.CarNameExceedMaxLengthException;

public class CarName {
    private static final int MAXIMUM_LENGTH = 5;
    private final String name;

    private CarName(String name) {
        this.name = name;
        validateMaximumLength();
    }

    public String getName() {
        return name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    private void validateMaximumLength() {
        if (this.name.length() > MAXIMUM_LENGTH) {
            throw new CarNameExceedMaxLengthException();
        }
    }
}
