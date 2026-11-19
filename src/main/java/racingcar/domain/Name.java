package racingcar.domain;

public class Name {

    public static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getValue() {
        return value;
    }
}





