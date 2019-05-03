package racing;

import java.util.Random;

import static racing.Consts.RANDOM_NUMBER_BOUNDARY;

public class Utils {
    public static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
