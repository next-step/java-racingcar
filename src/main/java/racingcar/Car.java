package racingcar;

public class Car {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void plusMoveCount() {
        moveCount++;
    }
}
