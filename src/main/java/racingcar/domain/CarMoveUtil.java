package racingcar.domain;

import java.util.Random;

public class CarMoveUtil {
        private static int MAX_RANDOM_NUM = 10;
        private static int MIN_RANDOM_MUM = 4;
    public static boolean isMove() {

        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUM) > MIN_RANDOM_MUM;
    }
}
