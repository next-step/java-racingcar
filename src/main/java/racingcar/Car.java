package racingcar;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_BLANK_NAME = "자동차 이름은 비어있을 수 없습니다.";
    private static final String ERROR_NAME_TOO_LONG = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= MOVE_THRESHOLD) {
            move();
        }
    }

    private void move() {
        position++;
    }

    private static void validateName(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
        if (isExceedMaxLength(name)) {
            throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
        }
    }

    private static boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    private static boolean isExceedMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }
}
