package racing;

import java.util.Random;

public class RandomNumberUtil {

    public static int createRandomNumber(int range) {
        return new Random().nextInt(range);
    }

    public static int returnParamNumber(int number) {
        return number;
    }
}
