package racing;

import java.util.Random;

public class RacingCar {

    public static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
