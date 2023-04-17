package racingcar;

public class Car {

    public static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.moveCount = moveCount;
    }

    public boolean moveCountIsGreaterThan(int maxMoveCount) {
        return moveCount > maxMoveCount;
    }

    public boolean moveCountIsEqualTo(int maxMoveCount) {
        return moveCount == maxMoveCount;
    }

    public String name() {
        return name;
    }

    public int moveCount() {
        return moveCount;
    }

    public void plusMoveCount() {
        moveCount++;
    }
}
