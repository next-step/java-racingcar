package racingcar.model;

public class CarName {
    private static final String ERR_NAME_LENGTH = "Names longer than 5 characters are not allowed.";
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERR_NAME_LENGTH);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
