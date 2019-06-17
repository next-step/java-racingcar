package racinggame;

import com.google.common.base.Preconditions;

import java.util.Random;

public class CarHandler {
    public static final int MIN_RANDOM_INTEGER = 0;
    public static final int MAX_RANDOM_INTEGER = 10;
    public static final int MIN_MOVE_NUMBER = 4;
    private static Random random = new Random();

    private static int getRandomInt() {
        return random.nextInt(MAX_RANDOM_INTEGER);
    }

    static boolean isMoveCondition(int number) {
        Preconditions.checkArgument(
                number >= MIN_RANDOM_INTEGER && number <= MAX_RANDOM_INTEGER,
                "숫자의 범위는 [" + MIN_RANDOM_INTEGER + " ~ " + MAX_RANDOM_INTEGER + "] 입니다."
        );
        return number >= MIN_MOVE_NUMBER;
    }

    public static boolean getRandomMoveCondition() {
        int randomInt = getRandomInt();
        return isMoveCondition(randomInt);
    }
}
