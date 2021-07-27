package util;

import java.util.Random;

public class RandomNumUtil {

    public static int makeRandomNumber() {
        return new Random().nextInt(10);
    }

}
