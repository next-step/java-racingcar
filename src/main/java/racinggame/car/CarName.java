package racinggame.car;

public class CarName {

    private static final int NAME_MIN_LENGTH = 0;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과하거나 공백이 될 수 없습니다.");
        }
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    private boolean isValidName(String name) {
        return name.trim().length() > NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH;
    }

    public String initName() {
        return name;
    }
}
