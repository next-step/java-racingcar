package racingcar.domain;

import java.util.Random;

public class Movement {

    private final static int MIN_MOVE = 0;
    private final static int MAX_MOVE = 9;
    private final static Random RANDOM = new Random();

    public static int getRandomMove() {
        return MIN_MOVE + RANDOM.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }
}
