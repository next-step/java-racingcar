package racingcar;

public class Car implements Vehicle {

    private Integer moveCount = 0;

    public Integer getMoveCount() {
        return moveCount;
    }

    @Override
    public void move() {
        moveCount++;
    }
}
