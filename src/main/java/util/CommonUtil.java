package util;

import java.util.Random;

public class CommonUtil {

    private static Random random;

    public static StringBuilder[] initializeArray(int length) {
        StringBuilder[] sb = new StringBuilder[length];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        return sb;
    }

    public static int getRandomNumber() {
        return random.nextInt(10);
    }

}
