package racing.domain;

public class CarName {
    private static final int NAME_LENGTH_MAX = 5;

    private final String value;

    public CarName(String name) {
        if (hasNoInput(name)) {
            throw new IllegalArgumentException("Null 또는 공백 입력");
        }
        
        if (isMoreThanMaxLength(name)) {
            throw new IllegalArgumentException("자동차이름은 5자를 초과할 수 없습니다.");
        }
        
        this.value = name;
    }

    public String value() {
        return value;
    }

    private boolean isMoreThanMaxLength(String name) {
        return name.length() > NAME_LENGTH_MAX;
    }

    private boolean hasNoInput(String name) {
        return name == null || name.isBlank();
    }
}
