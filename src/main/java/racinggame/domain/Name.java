package racinggame.domain;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private String name;

    private Name(final String name) {
        validateLengh(name);
        this.name = name.trim();
    }

    private static void validateLengh(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static Name create(final String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}