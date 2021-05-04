package racing.domain;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validate(name);
        return new CarName(name);
    }

    private static void validate(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름이 5자보다 깁니다.");
        }
    }

    public String getName() {
        return name;
    }
}
