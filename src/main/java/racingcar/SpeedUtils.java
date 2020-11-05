package racingcar;

import java.util.Random;

public class SpeedUtils {

    private static final int MOVE_LIMIT_SPEED = 4;
    private static final int RANDOM_NUMBER = 10;
    private static final String ERROR_MESSAGE_UTILITY_CLASS = "유틸성 클래스입니다.";
    private static final Random random = new Random();

    private SpeedUtils() {
        throw new IllegalStateException(ERROR_MESSAGE_UTILITY_CLASS);
    }

    public static boolean possibleMoveSpeed(int speed) {
        return speed >= MOVE_LIMIT_SPEED;
    }

    public static boolean possibleMoveSpeedByRandomSpeed() {
        return possibleMoveSpeed(getRandomSpeed());
    }

    public static int getRandomSpeed() {
        return random.nextInt(RANDOM_NUMBER);
    }
}
