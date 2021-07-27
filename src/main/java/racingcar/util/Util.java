package racingcar.util;

import java.util.Random;
import java.util.regex.Pattern;

public class Util {
    private static Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(10);
    }

    public static final Pattern pattern = Pattern.compile("(^[0-9]*$)");
}
