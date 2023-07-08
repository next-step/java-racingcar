package racingcar.car.domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
