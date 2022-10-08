package racing.domain.car;

public class CarName {

    public static final int NAME_VALID_LENGTH = 5;
    private final String value;

    public CarName(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("이름은 빈값일 수 없습니다");
        }

        if (value.length() > NAME_VALID_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
