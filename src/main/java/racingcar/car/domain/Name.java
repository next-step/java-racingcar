package racingcar.car.domain;

public class Name {

    private String value;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private static void validate(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
