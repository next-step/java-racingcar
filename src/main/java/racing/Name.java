package racing;

public class Name {
    private final String name;

    public static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 " + MAX_CAR_NAME_LENGTH + "자 이하여야 합니다.";

    public Name(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
