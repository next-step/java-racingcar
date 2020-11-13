package step5.util;

import java.util.Random;

public class CarUtils {
    private static final Random random = new Random();
    private static final int CAR_MOVE_MAX_BOUND = 10;
    private static final int MAX_CAR_NAME_NUMBER = 5;

    public static int getRandom() {
        return random.nextInt(CAR_MOVE_MAX_BOUND);
    }

    public static void carNameMaxValid(String[] carNames) {
        if (carNames.length > MAX_CAR_NAME_NUMBER) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다.");
        }
    }
}
