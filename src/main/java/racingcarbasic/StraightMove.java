package racingcarbasic;

import java.util.Random;

class StraightMove implements MoveStrategy {
    @Override
    public boolean move() {
        return new Random().nextInt(10) >=4;
    }
}




