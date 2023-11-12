package carracing;

import java.util.Random;

public class CarUtil {
    public static int getRandomNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        return randomNum;
    }
}
