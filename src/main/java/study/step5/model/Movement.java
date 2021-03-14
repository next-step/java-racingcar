package study.step5.model;

import java.util.Random;

/**
 * Movement Class
 *
 * 이동을 제한하는 클래스
 */
public class Movement {
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_RESTRICT = 4;
    private static final Random random = new Random();

    public Movement() {
    }

    public boolean isMove() {
        return random.nextInt(RANDOM_RANGE) >= MOVE_RESTRICT;
    }

    public int stopAndMove() {
        if (isMove()) {
            return 1;
        }
        return 0;
    }
}
