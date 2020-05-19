package step3;

import java.util.Random;

public interface CarInterface {

    static final int MAX_MOVE_LIMIT = 9;
    static final int MOVE_START_AT = 4;
    static final Random random = new Random();

    int getMoveCount();

}
