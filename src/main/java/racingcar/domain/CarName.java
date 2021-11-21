package racingcar.domain;

public class CarName {
    private final String name;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public CarName(final String name) {
        checkValidation(name);
        this.name = name.trim();
    }

    private void checkValidation(final String name) {
        if (name == null || name.isEmpty() || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("name length must be between" + MIN_LENGTH + "  and " + MAX_LENGTH);
        }
    }

    public String getName() {
        return this.name;
    }
}
