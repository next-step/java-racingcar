package racing.domain;

import java.util.Random;

public class Moving {
    private static final int MOVE_LIMIT = 10;
    private static final int MOVE_MIN = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    public int moveRandomNumber() {
        if (randomNumber() < MOVE_MIN) {
            return STOP;
        }
        return GO;
    }

    protected int randomNumber() {
        Random random = new Random();
        return random.nextInt(MOVE_LIMIT);
    }
}
