package carracing.domain;

public class Name {
    public static final int NAME_LENGTH_UPPER_BOUND = 5;

    private final String value;

    public Name(String value) {
        checkValidateValue(value.trim());
        this.value = value.trim();
    }

    private void checkValidateValue(String name) {
        if (name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException("자동차의 이름은 " + NAME_LENGTH_UPPER_BOUND + "를 초과할 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름이 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
