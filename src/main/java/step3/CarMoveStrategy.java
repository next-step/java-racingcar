package step3;

import java.util.Random;

public interface CarMoveStrategy {

    static final int MAX_MOVE_LIMIT = 9;
    static final int MOVE_START_AT = 4;

    int location = 0;

    boolean canMove();

}
