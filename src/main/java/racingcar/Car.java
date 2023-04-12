package racingcar;

import java.util.Random;

public class Car {
    private int movementCount = 0;

    public void move() {
        Random random = new Random();

        if (random.nextInt(10) >= 4) {
            movementCount += 1;
        }
        ResultView.printMovement(movementCount);
    }
}
