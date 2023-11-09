package step5_racingCarWithWinner.util;

import java.util.Random;

public class RacingGameUtils {

    public static int getRandomInt(int end) {
        return new Random().nextInt(end);
    }
}
