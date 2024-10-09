package racingcar;

public class Car {

    public static final int MOVE_CONDITION = 4;
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

    private static void validationCarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if (name.trim().length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5 미만의 글자여야 합니다.");
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
