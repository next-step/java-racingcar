package racingcar.domain;

import java.util.Random;

public class MoveRandomStrategy implements MoveStrategy {
    private final int STANDARD = 4;
    private final boolean GO = true;
    private final boolean STOP = false;
    private static final int BOUND = 10;

    @Override
    public boolean goOrStop() {
        int num = new Random().nextInt(BOUND);

        if (num > STANDARD) {
            return GO;
        }
        return STOP;
    }
}
