package racing;

public class Name {
    private final String name;

    public static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 " + MAX_CAR_NAME_LENGTH + "자를 초과할 수 없습니다. 다시 입력해주세요.";
    private static final String CAR_NAME_EMPTY_EXCEPTION_MESSAGE = "이름은 공백일 수 없습니다. 다시 입력해주세요.";

    public Name(String name) {
        validNameLength(name);
        validNameIsNotEmpty(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validNameIsNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
    }

}
