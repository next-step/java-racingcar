package racingcar.domain;

public class Name {

    public static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validateLength(value);
        validateBlank(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    private static void validateBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 불가능 합니다");
        }
    }

    public String getValue() {
        return value;
    }
}





