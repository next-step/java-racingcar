package racinggame.mvc.domain;

public final class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public CarName(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
