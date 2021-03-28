package step3;

import java.util.Random;

public class RacingCar {

    private static Random random = new Random();
    private int moveCount;

    public int move() {
        int temp = random.nextInt(10);
        if (temp >= 4) this.moveCount += temp;
        return this.moveCount;
    }
}
