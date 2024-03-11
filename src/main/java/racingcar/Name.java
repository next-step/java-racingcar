package racingcar;

public class Name {

    private final String value;

    public Name(String value) {
        if (value == null) {
            throw new IllegalArgumentException("자동차 이름에 null이 들어옴");
        }
        final String trimmedName = value.trim();
        assertValidName(trimmedName);

        this.value = trimmedName;
    }

    private void assertValidName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
        }
    }

    public String value() {
        return value;
    }
}
