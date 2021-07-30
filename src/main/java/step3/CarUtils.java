package step3;

import java.util.Random;

public class CarUtils {

    public static int getNumberForMovement() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
