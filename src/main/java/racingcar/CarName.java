package racingcar;

public class CarName {

    private static final String NOT_BLANK = "이름은 공백일 수 없습니다.";
    private static final String MAX_NAME_FORMAT = "이름은 %s자를 초과할수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        notBlank(name);
        maxLength(name);
    }

    private void notBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK);
        }
    }

    private void maxLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MAX_NAME_FORMAT, MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
