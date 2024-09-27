package racingcar;

import java.util.Random;

public class CarMoveUtil {
    public static boolean isMove() {
        Random random = new Random();
        return random.nextInt(10) > 4;
    }
}
