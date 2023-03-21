package racingcar;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private String value;

    private Name(final String value) {
        if (value.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없음.");
        }
        this.value = value;
    }

    public static Name of(final String value) {
        return new Name(value);
    }

    public String toString() {
        return value;
    }
}
