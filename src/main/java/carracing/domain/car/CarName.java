package carracing.domain.car;

public class CarName {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public CarName(String name) {
        checkNameLengthIsValid(name);
        this.name = name;
    }

    private void checkNameLengthIsValid(String name) {
        if (isNameLengthInvalid(name)) {
            throw new IllegalArgumentException(
                String.format("이름은 %d ~ %d 자리이어야 합니다", NAME_LENGTH_MIN, NAME_LENGTH_MAX)
            );
        }
    }

    private boolean isNameLengthInvalid(String name) {
        return name == null || name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX;
    }

    public String name() {
        return this.name;
    }
}
