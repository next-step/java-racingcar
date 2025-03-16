package racing;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isEmpty();
    }

    public String getName() {
        return name;
    }
}

