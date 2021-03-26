package step3;

import java.util.Random;

public class RacingCar {

    Random random = new Random();
    private int moveCount;

    public int move() {
        moveCount += random.nextInt(10);
        return moveCount;
    }
}
