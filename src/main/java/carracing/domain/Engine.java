package carracing.domain;

import java.util.Random;

/**
 * Engine
 * version 0.0.1
 *
 * history
 * 0.0.1) 클래스 신규생성
 */
public class Engine {

    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final int MOVABLE_MAX_NUMBER = 9;

    private static final int MOVE = 1;
    private static final int STOP = 0;

    private final Random random;

    public Engine(Random random) {
        this.random = random;
    }

    public int drive() {
        return random.nextInt(MOVABLE_MAX_NUMBER)>=MOVABLE_MIN_NUMBER ? MOVE : STOP;
    }
}
