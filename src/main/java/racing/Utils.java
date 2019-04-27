package racing;

import java.util.Random;

public class Utils {
    private static int RANDOM_NUMBER_BOUNDARY = 10;

    public static int generateRandomNum(){
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUNDARY);
    }
}
