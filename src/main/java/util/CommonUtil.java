package util;

import java.util.Random;

public class CommonUtil {

    public static int randomNumber(int valueBoundary) {
        Random random = new Random();
        return random.nextInt(valueBoundary);
    }

}
