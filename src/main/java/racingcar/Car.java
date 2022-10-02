package racingcar;

import java.util.Random;

public class Car {

    private int totalMoveCount;

    public int totalMoveCount() {
        return totalMoveCount;
    }

    public void move() {
        if (isPossibleToMove()) {
            this.totalMoveCount += 1;
        }
    }

    private boolean isPossibleToMove() {
        return (new Random().nextInt(10) >= 4);
    }
}
