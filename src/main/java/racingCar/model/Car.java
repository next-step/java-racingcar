package racingCar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    MoveStrategy moveStrategy;
    private String name;
    private int moveCount = 0;

    public Car(String name, MoveStrategy moveStrategy) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5글자 이하로 정해주세요.");
        }
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public int move() {
        if (moveStrategy.move()) {
            moveCount += 1;
        }
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
