package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    static final int MOVE_CHECK_NUMBER = 4;
    Random random = new Random();
    @Override
    public boolean movable() {
        if(random.nextInt(10) >= MOVE_CHECK_NUMBER){
            return true;
        }
        return false;
    }
}
