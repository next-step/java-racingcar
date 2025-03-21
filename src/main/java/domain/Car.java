package domain;

import java.util.Random;
import view.ResultView;

public class Car {
    private final Position position = new Position();
    private static final Random random = new Random();
    private static final int MOVE_THRS = 4;

    private int getRandomValue() {
        return random.nextInt(10);
    }

    private void move(int randomValue) {
        if (randomValue >= MOVE_THRS) {
            this.position.move();
        }
    }

    private void viewCurrentPosition() {
        ResultView.printResult(this.position.toString());
    }

    public void run() {
        int randomValue = getRandomValue();
        move(randomValue);
        viewCurrentPosition();
    }
}