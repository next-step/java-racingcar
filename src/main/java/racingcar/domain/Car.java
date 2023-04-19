package racingcar.domain;

public class Car {

    public static final int LIMIT_CAR_NAME_LENGTH = 5;
    private final String name;
    public static final int MOVE_CODITION_NUMBER = 4;
    public static final int DEFAULT_MOVE_COUNT = 0;

    private int moveCount = DEFAULT_MOVE_COUNT;

    public Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        if (name.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void increaseMoveCount() {
        this.moveCount++;
    }

    public int move(int randomNumber) {
        if (canMove(randomNumber)) {
            this.increaseMoveCount();
        }

        return this.moveCount;
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CODITION_NUMBER;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
