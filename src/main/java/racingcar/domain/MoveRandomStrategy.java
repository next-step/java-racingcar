package racingcar.domain;

import java.util.Random;

public class MoveRandomStrategy implements MoveStrategy {
    private static final int STANDARD = 4;
    private static final int BOUND = 10;
    private static final boolean GO = true;
    private static final boolean STOP = false;

    @Override
    public boolean goOrStop() {
        int num = new Random().nextInt(BOUND);

        if (num > STANDARD) {
            return GO;
        }
        return STOP;
    }
}
