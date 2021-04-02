package step4;

import java.util.Random;

public class RacingCar {

    private static Random random = new Random();
    private String carName;
    private int moveCount;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int move() {
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            this.moveCount ++;
        }
        return this.moveCount;
    }
}
