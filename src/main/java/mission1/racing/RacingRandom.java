package mission1.racing;

import java.util.Random;

public class RacingRandom {
    private Random rand = new java.util.Random();

    public int random() {
        int randomNum = rand.nextInt(10);

        return randomNum;
    }
}
