package study.step3.model;

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

    public int stopAndMove() {
        if(random.nextInt(RANDOM_RANGE) >= MOVE_RESTRICT) {
            return 1;
        }
        return 0;
    }
}
