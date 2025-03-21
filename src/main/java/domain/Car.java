package domain;

import java.util.Random;
import view.ResultView;

class Car {
    private final Position position = new Position();
    private static final Random random = new Random();
    private static final int MOVE_THRS = 4;

    void move() {
        this.position.increase();
    }

    void randomMove() {
        int randomValue = random.nextInt(10);
        if (randomValue >= MOVE_THRS) {
            move();
        }
    }

    void printCurrentPosition() {
        ResultView.printResult(this.position.toString());
    }
}