package racingcar.domain;

public class Car {
    public static final int MOVEABLE_POWER = 4;
    private int moveCount = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveForwardOrStop(int inputPower) {
        if (inputPower >= MOVEABLE_POWER) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }
}
