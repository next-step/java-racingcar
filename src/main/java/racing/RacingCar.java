package racing;

import java.util.Random;

public class RacingCar {

    public static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean isFourOrMore(int number) {
        if (number >= 4 ) {
            return true;
        }
        return false;
    }
}
