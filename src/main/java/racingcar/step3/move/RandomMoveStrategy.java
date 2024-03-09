package racingcar.step3.move;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final int STOP = 0;
    private final int GO_AHEAD = 1;
    private final int MINIMUM_MOVE_BOUND = 4;

    @Override
    public int move() {
        Random random = new Random();
        int sign = random.nextInt(10);

        if (isMoveSign(sign)) {
            return GO_AHEAD;
        }
        return STOP;
    }

    private boolean isMoveSign(int sign) {
        return MINIMUM_MOVE_BOUND <= sign;
    }
}
