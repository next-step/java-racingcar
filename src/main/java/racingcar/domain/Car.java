package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int currentPosition;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validationCarName(name);
        this.name = name.trim();
        this.currentPosition = position;
    }

    private void validationCarName(String name) {
        validateNotNullOrEmpty(name);
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.trim().length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + " 미만의 글자여야 합니다.");
        }
    }

    private static void validateNotNullOrEmpty(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
    }

    public int move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            currentPosition++;
        }
        return currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

}
