package racing;

import java.util.Random;

public class RandomMove implements MoveStrategy{

    public static final int NON_MOVE = 0;
    public static final int MOVE = 1;
    public static final int BOUNDARY = 4;

    Random random = new Random();

    @Override
    public Integer move() {
        if (BOUNDARY <= random.nextInt(10)) {
            return MOVE;
        }
        return NON_MOVE;
    }

}
