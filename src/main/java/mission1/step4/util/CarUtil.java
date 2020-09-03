package mission1.step4.util;

import java.util.Random;

public class CarUtil {
    private static final Random RANDOM =  new Random();

    private CarUtil(){}

    public static int getRandomValue() {
        return RANDOM.nextInt(10);
    }
}


