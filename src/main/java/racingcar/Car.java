package racingcar;

public class Car implements Vehicle {
    private final int MOVABLE_NUMBER = 4;

    private String name;
    private Integer moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getMoveCount() {
        return moveCount;
    }

    @Override
    public void move(int number) {
        if (isMovable(number)) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return "-".repeat(moveCount + 1);
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER;
    }
}
