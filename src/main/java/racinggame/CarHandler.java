package racinggame;

import com.google.common.base.Preconditions;

public class CarHandler {
    public static final int MIN_RANDOM_INTEGER = 0;
    public static final int MAX_RANDOM_INTEGER = 10;
    public static final int MIN_MOVE_NUMBER = 4;

    static boolean isMoveCondition(int number) {
        Preconditions.checkArgument(
                number >= MIN_RANDOM_INTEGER && number <= MAX_RANDOM_INTEGER,
                "숫자의 범위는 [" + MIN_RANDOM_INTEGER + " ~ " + MAX_RANDOM_INTEGER + "] 입니다."
        );
        return number >= MIN_MOVE_NUMBER;
    }

    static boolean getRandomMoveCondition() {
        int ruleNumber = RacingGameParameters.getNumberGenerator().generate();
        return isMoveCondition(ruleNumber);
    }

    public static void moveCarByRandomCondition(Car car) {
        if (getRandomMoveCondition()) {
            car.move();
        }
    }
}
