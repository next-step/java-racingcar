package racingcar;

public class Car implements Vehicle {
    private static int MOVABLE_NUMBER = 4;

    private Integer moveCount = 0;

    @Override
    public Integer getMoveCount() {
        return moveCount;
    }

    @Override
    public void move(int number) {
        if (isMovable(number)){
            moveCount++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER;
    }
}
