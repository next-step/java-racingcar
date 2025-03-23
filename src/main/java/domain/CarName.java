package domain;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다");
        }

        if (value.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
        }

        this.value = value;
    }

    public String getName() {
        return value;
    }
}
