package util;

import java.util.Random;

public class RandomUtil {
    public static int randomNumber() {
        return new Random().nextInt(10);
    }
}
