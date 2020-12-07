package racinggame.domain.car;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        if (name.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과하였습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
