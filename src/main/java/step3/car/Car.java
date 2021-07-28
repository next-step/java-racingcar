package step3.car;

import java.util.Random;

public class Car {

    private int movedDistance = 0;
    private Random random = new Random();

    public void tryMove() {
        int value = random.nextInt(10);
        if (isMoveCondition(value))
            move();
    }

    private boolean isMoveCondition(int value) {
        return value >= 4;
    }

    private void move() {
        movedDistance++;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
