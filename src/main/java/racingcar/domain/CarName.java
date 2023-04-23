package racingcar.domain;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 하며, 5자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
