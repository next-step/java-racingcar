package racing.util;

import java.util.Random;

public class RandomNumberGeneratorUtil {
    private static final int BOUNDARY = 10;

    public static int randomNumber() {
        return new Random().nextInt(BOUNDARY);
    }
}
