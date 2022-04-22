package racing.domain;

public class CarName {
    private static final String NAME_MAX_LENGTH_ERROR_MESSAGE = "이름은 5를 초과할 수 없습니다.";
    private static final String NAME_BLANK_ERROR_MESSAGE = "이름을 공백일 수 없습니다.";
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
        if (name.length() < 5) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_ERROR_MESSAGE);
        }
    }

}
