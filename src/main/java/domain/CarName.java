package domain;

public class CarName {
    private static final String NAME_LENGTH_ERROR_MESSAGE = "error : 이름 최대 길이를 초과했습니다.";
    private static final int NAME_LENGTH_MAX = 5;
    private final String name;

    public CarName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String value() {
        return name;
    }
}
